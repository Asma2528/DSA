// Problem: https://leetcode.com/problems/concatenation-of-array
class Solution {
    public int[] getConcatenation(int[] nums) {
        // TC - O(n)
        // SC = O(2n) // for returning result;
        int n=nums.length;
        int[] result=new int[n*2];

        // for(int i=0;i<n;i++){
        //     result[i]=nums[i];
        //     result[i+n]=nums[i];
        // }

        // Another way
        System.arraycopy(nums,0,result,0,n);
        System.arraycopy(nums,0,result,n,n);

        return result;
    }
}