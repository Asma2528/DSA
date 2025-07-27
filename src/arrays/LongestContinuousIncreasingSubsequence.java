// Problem: https://leetcode.com/problems/longest-continuous-increasing-subsequence
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // TC = O(n)
        // SC = O(1)
        int count=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                count++;
                if(max<count){
                    max=count;
                }
            }else{
                count=1;
            }
        }
        return max;
    }
}