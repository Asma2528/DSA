// Problem: https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
class Solution {
    int binarySearch(int[] nums, int target, boolean findFirst) {
        int index = -1;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                if (findFirst) {
                    high = mid - 1; // go left
                } else {
                    low = mid + 1;  // go right
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }
  
    
    int countFreq(int[] arr, int target) {
        // TC - O(logn)
        // SC - O(1)
        int first = binarySearch(arr, target, true);
        if (first == -1) return 0; 
        int last = binarySearch(arr, target, false);
        return last - first + 1;

    }
}
