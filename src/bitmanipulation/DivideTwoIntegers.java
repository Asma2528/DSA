// Problem: https://leetcode.com/problems/divide-two-integers/
class Solution {
    public int divide(int dividend, int divisor) {
        // Brute force approach
        // TC - O(dividend)
        // SC - O(1)
        // // 1. Handle the specific overflow case: -2147483648 / -1
        // if (dividend == Integer.MIN_VALUE && divisor == -1) {
        //     return Integer.MAX_VALUE;
        // }

        // // 2. Determine the sign of the result
        // // If one is negative and the other is positive, result is negative
        // boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // // 3. Convert to long and take absolute values 
        // // We use long because Math.abs(Integer.MIN_VALUE) is too large for an int
        // long absDividend = Math.abs((long) dividend);
        // long absDivisor = Math.abs((long) divisor);

        // int quotient = 0;

        // // 4. Subtract divisor from dividend until it's smaller than divisor
        // while (absDividend >= absDivisor) {
        //     absDividend -= absDivisor;
        //     quotient++;
        // }

        // return isNegative ? -quotient : quotient;

        // Optimal approach
        // TC - O(log.2.n)^2
        // SC - O(1)

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor)
            return 1;

        boolean isNegative = (dividend < 0) ^ (divisor < 0); // Determine the sign of the result

        int quotient = 0;

        // Work with absolute values to simplify the division process
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        while (n >= d) {
            int pow = 0;

            // Find the largest power of two such that d * (2^pow) is <= n
            while (n >= (d << (pow + 1))) { // d<<(pow+1) is equal to d * 2^(pow+1)
                pow++;
            }
            quotient += (1 << pow); // equal to adding 2^pow
            // Subtract the largest possible chunk of divisor from the dividend
            n -= (d << pow);
        }

        return isNegative ? -quotient : quotient;
    }
}