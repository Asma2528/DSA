// Problem: https://leetcode.com/problems/rotate-array
class Solution {

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // Brute force approach
        // Time complexity - O(n+k)
        // Space complexity - O(k)

        // if (n == 1 || k == 0) {
        //     return;
        // }

        // int[] temp = new int[k];

        // int j = 0;
        // for (int i = n - k; i < n; i++) {
        //     temp[j++] = nums[i];
        // }

        // for (int i = n - k - 1; i >= 0; i--) {
        //     nums[k+i] = nums[i];
        // }

        // for (int i = 0; i < k; i++) {
        //     nums[i] = temp[i];
        // }

        // Optimal force approach
        // Time complexity - O(2n)
        // Space complexity - O(1)

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

    }
}