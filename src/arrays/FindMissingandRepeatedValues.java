// Problem: https://leetcode.com/problems/find-missing-and-repeated-values/
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // Optimal approach - 1 (Using math)
        // TC - O(n^2)
        // SC - O(1)
        // long rep = -1;
        // long miss = -1;
        // int n = grid.length * grid.length;
        // long S = ((long) n * (n + 1)) / 2; // sum of n natural numbers
        // long S2 = ((long) n * (n + 1) * (2 * n + 1)) / 6; // sum of square of n natural number 
        // long Sn = 0; //sum of integers in nums;
        // long S2n = 0; //sum of squares of integers in nums;

        // for (int[] num : grid) {
        //     for (int nu : num) {
        //         Sn += (long) nu;
        //         S2n += (long) nu * (long) nu;
        //     }
        // }

        // long eq1 = S - Sn; // x - y
        // long eq2 = S2 - S2n; // x^2 - y^2 which means (x+y) (x-y)
        // // substituting eq1 which is x+y in eq2
        // // (x+y) (x-y) = eq2
        // // (x-y) = eq2 / (x+y)
        // // (x-y) = eq2 / eq1
        // eq2 = eq2 / eq1; //(x+y)

        // rep = (eq1 + eq2) / 2;
        // miss = rep - eq1;

        // return new int[] { (int) miss, (int) rep };

        // Optimal approach - 2 (Using xor)
        // Use this to understand the approach: nums = [4, 3, 6, 2, 1, 1]
        // TC - O(5n²)
        // SC - O(1)
        // Step 1: XOR all nums and 1..n
        int n = grid.length;
        int N = n * n; // total numbers from 1..N
        int xr = 0, zero = 0, one = 0;

        // Step 1: XOR all grid elements and all numbers from 1..N
        for (int[] row : grid) {
            for (int val : row) {
                xr ^= val;
            }
        }

        for (int i = 1; i <= N; i++) {
            xr ^= i;
        }

        // Step 2: Find rightmost set bit
        int bit = xr & -xr; // faster than ~(xr - 1)

        // Step 3: Partition into two buckets
        for (int[] row : grid) {
            for (int val : row) {
                if ((val & bit) != 0)
                    one ^= val;
                else
                    zero ^= val;
            }
        }
        for (int i = 1; i <= N; i++) {
            if ((i & bit) != 0)
                one ^= i;
            else
                zero ^= i;
        }

        // Step 4: Decide which is duplicate
        for (int[] row : grid) {
            for (int val : row) {
                if (val == one) {
                    return new int[] { one, zero }; // one = duplicate, zero = missing
                }
            }
        }
        return new int[] { zero, one }; // zero = duplicate, one = missing

    }
}