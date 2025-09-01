// Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(256) i.e O(1)
        // Approach: Generate all substrings till a repeating character is found
        // For checking if a character is repeated we will mark them in an array
        // Array of 255 length as there are total 256 ASCII characters all initalized to zero
        // Whenever a character is found it will be marked as 1
        // To check if a character is repeated we will check array. If its value is 1 will break the inner loop
        // int len = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     int[] ascii = new int[256];
        //     for (int j = i; j < s.length(); j++) {
        //         char c = s.charAt(j);
        //         if (ascii[c] == 1)
        //             break;
        //         len = Math.max(j - i + 1, len);
        //         ascii[c] = 1;
        //     }
        // }

        // return len;

        // Optimal Approach
        // TC - O(n)
        // SC - O(256) i.e O(1) (255) is constant space because it's a fixed size and does not scale with input.
        // Approach: l(left) and r(right) will start at 0. Will keep shifting r pointer and calculate the length and update the len variable
        // But if a repeatign character is found will update the left pointer the index after the repeating character is found.
        // ascii array will keep track of elements which are already visited. We will store the index in that place when they occured i.e r
        // So whenever a repeating character is found l is set to ascii[c] + 1;
        // Eg: abcadef
        // when a comes again l will be set from 0 to 4 thus the window will start from b
        int len = 0;
        int l = 0;
        int[] ascii = new int[256];
        Arrays.fill(ascii, -1); // Initialize all to -1 (unseen)

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(ascii[c]>=l){
                l = ascii[c] + 1;
            }
            len = Math.max(len, r-l+1);
            ascii[c] = r;
        }
        return len;
    }
}