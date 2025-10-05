// Problem: https://leetcode.com/problems/reverse-integer/
class Solution {
    public int reverse(int x) {
        int rev = 0;
        int mod = 0;

        while (x != 0) {
            mod = x % 10;
            x = x / 10;
            
            // Check for overflow before updating rev
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0; // Overflow for positive numbers
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && mod < -8)) {
                return 0; // Overflow for negative numbers
            }

            rev = (rev * 10) + mod;
        }

        return rev;
    }
}