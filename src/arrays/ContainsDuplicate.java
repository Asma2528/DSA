// Problem: https://leetcode.com/problems/contains-duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // TC - O(n)
        // SC - O(n)
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }
}