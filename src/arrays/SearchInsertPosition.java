// Problem: https://leetcode.com/problems/search-insert-position
class Solution {
    public int searchInsert(int[] nums, int target) {
        // Brute force approach 
        // TC - O(n)
        // SC - O(1)
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target){
        //         return i;
        //     }
        //     else if(nums[i]>target){
        //         return i;
        //     }
        // }
        
        // return nums.length;

        // Optimal approach 
        // TC - O(log n)
        // SC - O(1)
        int pos = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
                int mid = low + ((high - low) / 2);
                if(nums[mid]>=target){                  
                    pos = mid;
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

        return pos;  
    }
}