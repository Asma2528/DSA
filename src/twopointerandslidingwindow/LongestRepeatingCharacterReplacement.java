// Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
class Solution {
    public int characterReplacement(String s, int k) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(26) i.e O(1)
        /*
        Approach: Generate all substrings. Keep a hash array of size 26 where each index stands for an uppercase character. Count the frequency of that character in the string. Store the frequency count in the hash array
        Formula for knowing how many changes are required in a substring = length of substring - Frequency of maximum character appeared in substring
        when changes are <=k update maxLen 
        if changes are > k then break the inner loop as generating more substrings wont be of use
        */
        // int maxLen = 0;
        // int maxFreq = 0;
        // int changes = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     int[] hash = new int[26];
        //     for (int j = i; j < s.length(); j++) {
        //         hash[s.charAt(j)-'A']++;
        //         maxFreq = Math.max(maxFreq ,hash[s.charAt(j)-'A']);
        //         changes = (j-i+1) - maxFreq;
        //         if(changes<=k){
        //             maxLen = Math.max(maxLen,j-i+1);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }

        // return maxLen;

        // Better approach
        // TC - O(2n)
        // SC - O(26) i.e O(1)
        /*
        Here we will be keeping left and right pointer where right pointer will keep on shifting. Simultanouesly we will be updating frequency of characters in hash array and calculate max frequencies. when the no of changes exceeds k we will shift left pointer until the no of changes is <=k
        */
        // int maxLen = 0;
        // int left = 0;
        // int maxFreq = 0;
        // int changes = 0;
        // int[] hash = new int[26];
        // for(int right = 0;right<s.length(); right++){
        //     hash[s.charAt(right)-'A']++;
        //     maxFreq = Math.max(maxFreq ,hash[s.charAt(right)-'A']);
            +
        //     while(((right-left+1) - maxFreq) > k){
        //         hash[s.charAt(left)-'A']--;
        //         left++;
        //         maxFreq = Math.max(maxFreq ,hash[s.charAt(left)-'A']);
        //     }
        //     if(((right-left+1) - maxFreq)<=k){
        //         maxLen = Math.max(maxLen,right-left+1);
        //     }
        // }

        // return maxLen;

        // Optimal approach
        // TC - O(n)
        // SC - O(26) i.e O(1)
        /*
        Approach: It is similar to better approach but here we are eliminating inner loop and shifting the left pointer by 1 at a time and updating max lenght only when no of changes are <= k
        */
        int maxLen = 0;
        int left = 0;
        int maxFreq = 0;

        int[] hash = new int[26];
        for(int right = 0;right<s.length(); right++){
            hash[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq ,hash[s.charAt(right)-'A']);
  
            if(((right-left+1) - maxFreq) >k){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            if(((right-left+1) - maxFreq)<=k){
                maxLen = Math.max(maxLen,right-left+1);
            }
        }

        return maxLen;
    }
}