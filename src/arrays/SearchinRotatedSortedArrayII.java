// Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
class Solution {
    public boolean search(int[] nums, int target) {
        // Brute force approach - Linear Search
        // TC - O(n)
        // SC - O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return true;
        //     }
        // }
        // return false;

        // Optimal approach - Binary Search (since we have to search and have a sorted array)
        // TIP: if you get questions envolving duplicates then try to solve them as unique element based and modify the code where the condition fails , for ex here it breaks at identifying the sorting portion. If not able to identify then need to search for different solution
        // TC - Average case: O(log n), Worst case - O(n/2)
        // SC - O(1)
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return true;
            }
            // Edge case
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }
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
        return false;
    }
}