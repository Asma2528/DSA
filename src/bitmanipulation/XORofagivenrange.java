// Problem: https://www.geeksforgeeks.org/problems/xor-of-a-given-range/1
class Solution {
    public int getXor(int[] nums, int a, int b) {
        int xor = 0;
        for(int i = a; i <=b ; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
}