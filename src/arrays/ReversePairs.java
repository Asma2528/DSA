// Problem: https://leetcode.com/problems/reverse-pairs
class Solution {
    // TC - O(n logn)
    public void merge(int[] nums, int low, int mid, int high) {
        int temp[] = new int[high - low + 1];
        int ptr1 = low;
        int ptr2 = mid + 1;
        int idx = 0;

        while (ptr1 <= mid && ptr2 <= high) {
            if (nums[ptr1] < nums[ptr2]) {
                temp[idx++] = nums[ptr1++];
            } else {
                temp[idx++] = nums[ptr2++];
            }
        }

        while (ptr1 <= mid) {
            temp[idx++] = nums[ptr1++];
        }

        while (ptr2 <= high) {
            temp[idx++] = nums[ptr2++];
        }

        for (int i = 0, j = low; i < temp.length; i++, j++) {
            nums[j] = temp[i];
        }
    }

    // TC - O(n logn)
    public int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2 * (long) nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }

    public int divide(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;

        int mid = (low + high) / 2;

        count += divide(nums, low, mid);
        count += divide(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    public int reversePairs(int[] nums) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // int count = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //          if ((long) nums[i] > 2 * (long) nums[j]) {
        //             count++;
        //         }
        //     }
        // }

        // return count;

        // Optimal approach - Using merge sort
        // TC - O(2*(n logn))
        // SC - O(1)

        return divide(nums, 0, nums.length - 1);

    }
}