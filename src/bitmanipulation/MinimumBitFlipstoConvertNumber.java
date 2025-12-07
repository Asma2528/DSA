// Problem: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
class Solution {
    public int minBitFlips(int start, int goal) {
        // TC - O(no of set bits in n)
        // SC - O(1)
        int n = start ^ goal;

        int cnt = 0;
        while(n!=0){
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}