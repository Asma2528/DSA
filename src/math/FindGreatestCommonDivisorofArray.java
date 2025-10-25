// Problem: https://leetcode.com/problems/find-greatest-common-divisor-of-array/
class Solution {
    public int GCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) {
            return b;
        }

        return a;
    }

    public int findGCD(int[] nums) {
        // TC - O(n) + O(log phi(min (a,b)))
        // SC - O(1)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }

        return GCD(min, max);
    }
}