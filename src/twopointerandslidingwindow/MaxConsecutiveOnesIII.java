// Problem: https://leetcode.com/problems/max-consecutive-ones-iii/
class Solution {
    public int longestOnes(int[] nums, int k) {
        // Asssume this problem is Finding largest subarray with atmost k zeroes
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // int maxOnes = 0;
        // for(int i=0;i<nums.length;i++){
        //     int zeroes = 0;
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[j]==0){
        //             zeroes++;
        //         }
        //         if(zeroes>k){
        //             break;
        //         }
        //         maxOnes = Math.max(maxOnes, j - i + 1);
        //     }
        // }

        // return maxOnes;

        // Better approach
        // TC - O(2n)
        // SC - O(1)
        // int maxOnes = 0;
        // int left = 0;
        // int zeroes = 0;
        // for(int right=0;right<nums.length;right++){
        //     if(nums[right]==0){
        //         zeroes++;
        //     }
        //     while(zeroes>k){
        //         if(nums[left]==0){
        //             zeroes--;
        //         }
        //         left++;
        //     }
        //     maxOnes = Math.max(maxOnes, right - left + 1);
        // }

        // return maxOnes;

        // Optimal approach
        // TC - O(n)
        // SC - O(1)
        int maxOnes = 0;
        int left = 0;
        int zeroes = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroes++;
            }
            if(zeroes>k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            else{
                maxOnes = Math.max(maxOnes, right - left + 1);
            }
        }

        return maxOnes;
    }
}