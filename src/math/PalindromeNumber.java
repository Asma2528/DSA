// Problem: https://leetcode.com/problems/palindrome-number
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int org = x;
        int rev = 0;

        while (org != 0) {
            int rem = org % 10;
            rev = rev * 10 + rem;
            org = org / 10;
        }

        return rev == x;
    }
}