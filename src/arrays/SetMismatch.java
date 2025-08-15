// Problem: https://leetcode.com/problems/set-mismatch/
class Solution {
    public int[] findErrorNums(int[] nums) {
        // Brute force approach
        // TC - O(n^2)
        // SC - O(1)
        // int rep = -1;
        // int miss = -1;

        // for (int i = 1; i <= nums.length; i++) {
        //     int count = 0;
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i == nums[j]) {
        //             count++;
        //         }
        //     }
        //         if (count == 2) {
        //             rep = i;
        //         }
        //         if (count == 0) {
        //             miss = i;
        //         }
        //         if (rep != -1 && miss != -1) {
        //             break;
        //         }
        // }

        // return new int[] { rep, miss };

        // Better approach
        // TC - O(2n)
        // SC - O(n)
        // int rep = -1;
        // int miss = -1;
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // for (int i = 1; i <= nums.length; i++) {
        //     if (!map.containsKey(i)) {
        //         miss = i;
        //     }
        //     if (map.getOrDefault(i, 0) == 2) {
        //         rep = i;
        //     }
        //     if (rep != -1 && miss != -1) {
        //         break;
        //     }
        // }
        // return new int[] { rep, miss };

        // Optimal approach - 1 (Using math)
        // TC - O(n)
        // SC - O(1)
        // long rep = -1;
        // long miss = -1;
        // int n = nums.length;
        // long S = ((long) n * (n + 1)) / 2;  // sum of n natural numbers
        // long S2 = ((long)n * (n + 1) * (2 * n + 1)) / 6; // sum of square of n natural number 
        // long Sn = 0; //sum of integers in nums;
        // long S2n = 0; //sum of squares of integers in nums;

        // for (int num : nums) {
        //     Sn += (long) num;
        //     S2n += (long) num * (long)num;
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
        // TC - O(3n)
        // SC - O(1)
        int xr = 0;
        int zero = 0;
        int one = 0;

        // Step 1: XOR all nums and 1..n
        for (int i = 0; i < nums.length; i++) {
            xr = xr ^ nums[i];
            xr = xr ^ (i + 1);
        }

        // Step 2: Find rightmost set bit 
        int bit = xr & ~(xr - 1);

        // Step 3: Divide into two buckets and XOR separately
        // zero - means at the 'bit' position num has zero
        // one - means at the 'bit' position num has one
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bit) != 0) {
                one = one ^ nums[i];
            } else {
                zero = zero ^ nums[i];
            }
            if (((i + 1) & bit) != 0) {
                one = one ^ (i + 1);
            } else {
                zero = zero ^ (i + 1);
            }
        }

        // Step 4: Check which one is the duplicate
        for (int num : nums) {
            if (num == one) {
                return new int[] { one, zero }; // one - duplicate, zero - missing
            }
        }

        return new int[] { zero, one }; // zero - duplicate, one - missing

        // 1. Math Approach
        // Pros:
        // Conceptually straightforward — based on sum and sum of squares formulas.
        // Works in exactly O(n) time (single pass).
        // Easy to understand mathematically.

        // Cons:
        // Vulnerable to overflow if numbers are large (needs explicit long or even BigInteger in extreme cases).
        // Floating-point methods (if used) can lose precision.
