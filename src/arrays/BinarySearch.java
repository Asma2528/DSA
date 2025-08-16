// Problem: https://leetcode.com/problems/binary-search/
class Solution {
    public int findMid(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return findMid(nums, low, mid - 1, target);
        } else {
            return findMid(nums, mid + 1, high, target);
        }
    }

    public int search(int[] nums, int target) {
        // TC - O(log n)
        // SC - O(1)
        // Iterative approach
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
        // Recursive approach
        // return findMid(nums, 0, nums.length - 1, target);

    }
}