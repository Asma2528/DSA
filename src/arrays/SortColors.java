// Problem: https://leetcode.com/problems/sort-colors
class Solution {
    public void sortColors(int[] nums) {
        // Better approach
        // TC - O(2n)
        // SC - O(1)
        // int c0 = 0;
        // int c1 = 0;
        // int c2 = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         c0++;
        //     } else if (nums[i] == 1) {
        //         c1++;
        //     } else {
        //         c2++;
        //     }
        // }

        // for (int i = 0; i < c0; i++) {
        //     nums[i] = 0;
        // }

        // for (int i = c0; i < c0 + c1; i++) {
        //     nums[i] = 1;
        // }

        // for (int i = c0 + c1; i < c0 + c1 + c2; i++) {
        //     nums[i] = 2;
        // }

        // Optimal approach (Dutch National Flag Algorithm)
        // TC - O(n)
        // SC - O(1)
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}