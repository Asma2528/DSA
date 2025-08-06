// Problem: https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        // TC - O(n)
        // SC - O(1)

        int sum = 0;
        int largestSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            largestSum = Math.max(largestSum, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return largestSum;
    }
}