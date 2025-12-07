// Problem: https://leetcode.com/problems/number-of-1-bits/
class Solution {
    public int hammingWeight(int n) {
        // Hamming Weight (also called Population Count, popcount, or count of set bits) is: The number of 1s in the binary representation of a number.

        // Brute force approach
        // TC - O(log n)
        // SC - O(1)
        // int cnt = 0;

        // while (n > 1) {
        //     cnt += n & 1;
        //     n = n >> 1;
        // }

        // return n == 1 ? cnt + 1 : cnt;

        // Optimized approach
        // TC - O(no of set bits)
        // SC - O(1)
        int cnt = 0;

        while (n!=0) {
            n = n & (n-1);
            cnt ++;
        }

        return cnt;
    }
}