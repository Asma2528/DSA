// Problem: https://leetcode.com/problems/next-permutation
class Solution {
    public void nextPermutation(int[] nums) {
        // Brute force approach
        // 1. Generate all permutations
        // 2. Do a linear search to find the permutaion
        // 3. Return the next permutation
        // TC - O(n * n!)
        // SC - O(n!)

        // Optimal Approach
        // TC - O()
        // Steps:
        // 1. Find the breakpoint (where preceding element is smaller than next element). Suppose k is the breakpoint
        // If no breakpoint found means it is the last permuation. Thus will reverse it inorder to find the first permutation
        // 2. find element greater than breakpoint and then swap the element with the breakpoint
        // 3. Reverse remaining elements

        // Step 1: Find the breakpoint
        int breakpoint = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        if (breakpoint != -1) {
            // Step 2: Find element greater than nums[breakpoint] and swap
            for (int j = nums.length - 1; j > breakpoint; j--) {
                if (nums[j] > nums[breakpoint]) {
                    int temp = nums[j];
                    nums[j] = nums[breakpoint];
                    nums[breakpoint] = temp;
                    break;
                }
            }

            // Step 3: Reverse the part of the array after breakpoint
            int start = breakpoint + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        } else {
            // Step 4: If no breakpoint, it means the array is in descending order
            // Reverse the entire array to get the first permutation
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}