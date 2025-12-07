// Problem: https://leetcode.com/problems/hamming-distance/
class Solution {
    public int hammingDistance(int x, int y) {
        // TC - O(no of set bits in n)
        // SC - O(1)
        int n = x ^ y;

        int cnt = 0;
        while(n!=0){
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}