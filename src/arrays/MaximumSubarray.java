// Problem: https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        // Brute apporach
        // TC - O(n^2)
        // SC - O(1)
        // int sum;
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        //     sum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         max = Math.max(max, sum);
        //     }
        // }
        // return max;

        // Optimal apporach (Kadane's Algorithm)
        // TC - O(n)
        // SC - O(1)
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max=Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}