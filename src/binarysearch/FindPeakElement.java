// Problem: https://leetcode.com/problems/find-peak-element
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        // Brute force approach
        // TC - O(n)
        // SC - O(1)
        // for (int i = 0; i < n; i++) {
        //     if (i == 0) {
        //         if (nums[i] > nums[i + 1]) {
        //             return i;
        //         }
        //     } else if (i == n - 1) {
        //         if (nums[i] > nums[i - 1]) {
        //             return i;
        //         }
        //     } else {
        //         if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
        //             return i;
        //         }
        //     }
        // }

        // Optimal approach - Using binary search
        // TC - O(log n)
        // SC - O(n)
        if(nums[0]>nums[1]){
            return 0;
        }

        if(nums[n-2]<nums[n-1]){
            return n-1;
        }

        int low = 1, high = n - 2;

        while(low<=high){
            int mid = low + ((high - low) / 2);
            if(nums[mid - 1]<nums[mid] && nums[mid + 1]<nums[mid]){
                return mid;
            }
            else if(nums[mid - 1]<nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}