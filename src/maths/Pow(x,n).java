// Problem: https://leetcode.com/problems/powx-n/
class Solution {
    public double myPow(double x, int n) {
        // TC - O(log base to 2 n)
        // SC - O(1)
        if (n == 0) {
            return 1;
        }

        // Java's int type is a 32-bit signed integer, which has a range from -2^31 to 2^31 - 1 (i.e., from -2147483648 to 2147483647. Directly making it positive will overflow Int ma value
        if (n == Integer.MIN_VALUE) {
            x = x * x; // Square x to handle the overflow issue.
            n = n / 2;
        }

        double result = 1;
        boolean isNegative = n < 0;
        if (isNegative) {
            n = -n;
        }

        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x = x * x;
            n = n / 2;
        }

        if (isNegative) {
            result = 1.0 / result;
        }

        return result;
    }
}