// Problem: https://leetcode.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        // TC - O(n)
        // SC - O(1)
        int maxIdx = 0; // maxIdx keeps track of the farthest index we can reach so far
        // Iterate through each index of the array
        for(int i=0;i<nums.length;i++){
            // If our current index is greater than the farthest we can reach,
            // it means we cannot proceed further — return false
            if(i>maxIdx){
                return false;
            }

            // Update maxIdx to the maximum of its current value or the
            // farthest we can reach from current index (i + nums[i])
            maxIdx = Math.max(maxIdx,i+nums[i]);
        }

        // If we complete the loop, it means we can reach the end
        return true;
    }
}