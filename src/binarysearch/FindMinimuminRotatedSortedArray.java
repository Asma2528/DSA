// Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {
        // Brute force approach
        // TC - O(n)
        // SC - O(1) [Here we have used the existing space only]
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] < min) {
        //         min = nums[i];
        //     }
        // }
        // return min;

        // Optimal approach
        // TC - O(log n), Worst case where all elements are sam O(n/2)
        // SC - O(1)
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if(nums[low]<=nums[high]){
                result = Math.min(result,nums[low]);
                break;
            }

            if(nums[low]<=nums[mid]){
                result=Math.min(result,nums[low]);
                low = mid + 1;
            }
            else{
                result=Math.min(result,nums[mid]);
                high = mid - 1;
            }
        }

        return result;

    }
}
