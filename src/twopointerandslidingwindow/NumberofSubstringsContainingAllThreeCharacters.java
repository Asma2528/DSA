// Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
class Solution {
    public int numberOfSubstrings(String s) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        /*
        Approach: Generate all subarrays and when it contains all 3 characters, the count of hash will be 3. At that time update cnt.
        */
        // hash[s.charAt(j) - 'a'] = 1; This line maps the character 'a', 'b', or 'c' to an index (0, 1, or 2) in the array called hash, and sets that index to 1 to mark that the character has been seen.
        // Characters in Java (and most programming languages) have ASCII/Unicode values.
        // 'a' = 97
        // 'b' = 98
        // 'c' = 99
// If you subtract 'a' (97) from each character: you will either get 0 for a, 1 for b and 2 for c. Thus the corresponsing index in hash array will be marked as 1 whenever a,b,c is encountered.

        // int cnt = 0;
        // for(int i=0;i<s.length(); i++){
        //     int[] hash = new int[3];
        //     for(int j=i;j<s.length();j++){
        //         hash[s.charAt(j)-'a'] = 1; 
        //         if(hash[0] + hash[1] + hash[2]==3){
        //             cnt++;
        //         }
        //     }
        // }

        // return cnt;
        
        // Better approach
        // TC - Near O(n^2)
        // SC - O(1)
        /*
        Idea: Using brute force but stopping the inner loop when a single valid subarray containing abc is encountered. Updating cnt as length of string - index at which subarray is encountered.
        Reason: If at any point we get valid sub array it means all the subarray after that will also be valid.
        */
        // int cnt = 0;
        // for(int i=0;i<s.length(); i++){
        //     int[] hash = new int[3];
        //     for(int j=i;j<s.length();j++){
        //         hash[s.charAt(j)-'a'] = 1; 
        //         if(hash[0] + hash[1] + hash[2]==3){
        //             cnt = cnt + (s.length() - j);
        //             break;
        //         }
        //     }
        // }

        // return cnt;

        // Optimal approach
        // TC - O(n)
        // SC - O(1)
        /*
        Approach: We will be updating the index value wheenever we get a,b,c
        When 0,1,2 index is not equal to -1. from that time onwards we will start counting subarrays.
        */
        int lastSeen[] = {-1,-1,-1};
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a'] = i;
            cnt+= 1 + Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
        }
        return cnt;
    }
}