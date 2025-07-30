// Problem: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Sliding window (Only for positive numbers)
        // Optimal approach (but o)
        // TC - O(n^2)
        // SC - O(1)
        int sum = 0;
        int longest = 0;
        int left = 0;
        int right = 0;
        
        while (right < arr.length) {
            sum += arr[right];
            
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == k) {
                longest=Math.max(longest,right-left+1);
            }
            
            right++;
        }

        return longest;
    }
}
