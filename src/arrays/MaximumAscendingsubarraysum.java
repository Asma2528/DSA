// Problem: https://leetcode.com/problems/maximum-ascending-subarray-sum
class Solution {
    public int maxAscendingSum(int[] nums) {
        // Brute apporach 
        // TC - O(n^2)
        // SC - O(1)
        // int sum;
        // int max = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum = nums[i];
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] > nums[j - 1]) {
        //             sum += nums[j];
        //         } else {
        //             break;
        //         }
        //     }
        //     max = Math.max(max, sum);
        // }

        // return max;

        // Optimal apporach (Kadane's Algorithm)
        // TC - O(n)
        // SC - O(1)
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}