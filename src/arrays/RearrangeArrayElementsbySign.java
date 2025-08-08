// Problem: https://leetcode.com/problems/rearrange-array-elements-by-sign
class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Brute force approach
        // TC - O(n) + O(n/2)
        // SC - O(n)
        // int[] pos = new int[nums.length / 2];
        // int[] neg = new int[nums.length / 2];
        // int k = 0, j = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] < 0) {
        //         neg[k] = nums[i];
        //         k++;
        //     } else {
        //         pos[j] = nums[i];
        //         j++;
        //     }
        // }

        // for (int i = 0; i < nums.length / 2; i++) {
        //     nums[2 * i] = pos[i];
        //     nums[2 * i + 1] = neg[i];
        // }

        // return nums;

        // Optimal force approach
        // TC - O(n) 
        // SC - O(n)
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg += 2;
            } else {
                ans[pos] = nums[i];
                pos += 2;
            }
        }

        return ans;
    }
}