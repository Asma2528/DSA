// Problem: https://leetcode.com/problems/alternating-digit-sum
class Solution {
    public int alternateDigitSum(int n) {
        // Optimal approach
        // TC - O(n) 
        // SC - O(1)
        String numStr = String.valueOf(n);
        int sum = 0;

        for (int i = 0; i < numStr.length(); i++) {
            int num = numStr.charAt(i) - '0';
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum -= num;
            }
        }

        return sum;
    }
}