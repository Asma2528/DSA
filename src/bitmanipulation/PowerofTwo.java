// Problem: https://leetcode.com/problems/power-of-two/
class Solution {
    public boolean isPowerOfTwo(int n) {
        // TC - O(1)
        // SC - O(1)
        if(n > 0 && (n & (n - 1)) == 0){
            return true;
        }

        return false;
    }
}