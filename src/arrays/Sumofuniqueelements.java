// Problem: https://leetcode.com/problems/sum-of-unique-elements
class Solution {
    public int sumOfUnique(int[] nums) {
        // Brute force would be to use HashSet or HashMap

        // Optimal approach
        // TC - O(2n)
        // SC - O(1)
        int[] temp=new int[101];
        int sum=0;

        for(int n:nums){
            temp[n]++;
        }

        for(int n:nums){
            if(temp[n]==1){
                sum+=n;
            }
        }
        
        return sum;
    }
}