// Problem: https://leetcode.com/problems/max-consecutive-ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // TC = O(n)
        // SC = O(1)
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }
}