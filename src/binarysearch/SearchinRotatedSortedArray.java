// Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        // Brute force approach - Linear Search
        // TC - O(n)
        // SC - O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return i;
        //     }
        // }
        // return -1;

        // Optimal approach - Binary Search (since we have to search and have a sorted array)
        // TC - O(log n)
        // SC - O(1)
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return mid;
            }
            // Identify the sorted half and check if the element is in sorted half. 
            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}