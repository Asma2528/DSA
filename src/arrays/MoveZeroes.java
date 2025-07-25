// Problem: https://leetcode.com/problems/move-zeroes/
class Solution {

    public void moveZeroes(int[] nums) {
        // Brute-force approach
        // Time complexity - O(2n)
        // Space complexity - O(n)

        // int temp[] = new int[nums.length];
        // int j = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         temp[j++] = nums[i];
        //     }
        // }

        // for (int i = j; i < nums.length; i++) {
        //     temp[j]=0;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     nums[i]=temp[i];
        // }

        // Better approach
        // Time complexity - O(n)
        // Space complexity - O(1)
        // int j = -1;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         j = i;
        //         break;
        //     }
        // }

        // if (j == -1) {
        //     return;
        // }

        // for (int i = j + 1; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         nums[j] = nums[i];
        //         nums[i] = 0;
        //         j++;
        //     }
        // }

        // Optimal approach (Easier to understand)
        // Time complexity - O(n)
        // Space complexity - O(1)
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}