// Problem: https://leetcode.com/problems/sqrtx/
class Solution {
    public int mySqrt(int x) {
        // Brute force approach
        // TC - O(n)
        // ṢC - O(1)
        // int result = 0;

        //  for (int i = 1; (long)i * i <= x; i++) {
        //     result = i; 
        // }

        // return result;

        // Optimal approach - Using binary search
        // Note: You can either return high or can also store it in a variable (result) and return that.
        // TC - O(log n)
        // SC - O(1)
        int low = 1;
        int high = x;
        // int result = 0;

        while(low<=high){
            int mid = low +((high - low)/2);
            long prod = (long) mid * mid;
            if(prod <= x){
                // result = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        // return result
        return high;
    }
}