// Problem: https://leetcode.com/problems/fibonacci-number
class Solution {
    public int fib(int n) {
        // Using recursion
        // TC - O(2^n)
        // SC - O(n) recursive stack space
        if(n<=1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}