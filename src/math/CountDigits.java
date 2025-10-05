// Problem: https://www.geeksforgeeks.org/problems/count-digits-1606889545/1
class Solution {
    public int countDigits(int n) {
        // TC - O(log10 n)
        // SC - O(1)
        // int cnt = 0;
        
        // while(n!=0){
        //     cnt++;
        //     n = n/ 10;
        // }
        
        // return cnt;
        
        // 2nd Approach
        if (n == 0) {
            return 1;  // 0 has 1 digit
        }
        
        // For positive numbers, calculate log base 10
        return (int) (Math.log(n) / Math.log(10)) + 1;   
        
    }
}
