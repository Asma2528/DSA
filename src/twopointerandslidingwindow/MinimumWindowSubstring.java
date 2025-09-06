// Problem: https://leetcode.com/problems/minimum-window-substring
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return ""; // If s is smaller than t, no window is possible

        // Brute force approach
        // TC - O(n^3)
        // SC - O(52) i.e O(1)
        // String minStr = "";
        // int min = Integer.MAX_VALUE;

        // for (int i = 0; i < s.length(); i++) {
        //     int[] hash = new int[52];  // Array for lowercase and uppercase letters
        //     int tcnt = 0;

        //     // Build the hash array for string t (both lowercase and uppercase)
        //     for (int k = 0; k < t.length(); k++) {
        //         char c = t.charAt(k);
        //         if (Character.isLowerCase(c)) {
        //             hash[c - 'a']++;  // For lowercase letters 'a' to 'z'
        //         } else {
        //             hash[c - 'A' + 26]++;  // For uppercase letters 'A' to 'Z'
        //         }
        //     }

        //     // Now, iterate through string s and check for the valid window
        //     for (int j = i; j < s.length(); j++) {
        //         char c = s.charAt(j);
        //         if (Character.isLowerCase(c)) {
        //             if (hash[c - 'a'] > 0) {
        //                 tcnt++;
        //             }
        //             hash[c - 'a']--;  // Decrease the count of the current character
        //         } else {
        //             if (hash[c - 'A' + 26] > 0) {
        //                 tcnt++;
        //             }
        //             hash[c - 'A' + 26]--;  // Decrease the count of the current character
        //         }

        //         if (tcnt == t.length()) {
        //             // If the window contains all characters from t
        //             if ((j - i + 1) < min) {
        //                 min = j - i + 1;
        //                 minStr = s.substring(i, j + 1);
        //             }
        //         }
        //     }
        // }

        // return minStr;

        // Optimal approach
        // TC - O(2n)
        // SC - O(52) i.e O(1)
        String minStr = ""; 
        int min = Integer.MAX_VALUE; // Track minimum window length
        int left = 0;                // Left pointer of sliding window
        int tcnt = 0;                // Number of characters matched so far
        int[] hash = new int[52];    // Frequency array for both uppercase & lowercase chars


        // First will count the t characters in hash array
        for (char c : t.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hash[c - 'a']++; // 'a' → 0, 'b' → 1, ..., 'z' → 25
            } else {
                hash[c - 'A' + 26]++; // 'A' → 26, 'B' → 27, ..., 'Z' → 51
            }
        }

        // Expand the window with right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int idx = Character.isLowerCase(c) ? (c - 'a') : (c - 'A' + 26);

            if (hash[idx] > 0) { // If the hash is positive it means it is in t string
                tcnt++; // count to track how many characters have already appeared in s substring which is in t string
            }
            hash[idx]--;

            // When we have all required characters (tcnt == t.length())
            while (tcnt == t.length()) { // It means we have got all the characters of t string in our s substring
                if (min > right - left + 1) {
                    min = right - left + 1;
                    minStr = s.substring(left, right + 1);
                }

                // Try to shrink from the left
                char cLeft = s.charAt(left);
                int idxLeft = Character.isLowerCase(cLeft) ? (cLeft - 'a') : (cLeft - 'A' + 26);

                hash[idxLeft]++;  // Put back the left character into hash

                if (hash[idxLeft] > 0) {
                    tcnt--; // If this character was part of t and now missing, reduce matched count
                }

                left++; // Shrink window: We will try to make the s substring as small as possible
            }
        }

        return minStr;
    }
}
