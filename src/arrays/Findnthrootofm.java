// Problem: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
class Solution {
    public int pow(int a, int n, int m) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * a;
            if (result > m) {
                return 2; // means a^n > m
            }
        }
        if (result == m) return 1;  // exact match
        return 0;                   // means a^n < m
    }

    public int nthRoot(int n, int m) {
        // Brute force approach
        // TC - O(m) * O(logn)
        // SC - O(1)
        // for(int i=1;i<=m;i++){
        //     int pow = (int) Math.pow(i,n);
        //     if(pow==m){
        //       return i; 
        //     }
        //     else if (pow>m){
        //         break;
        //     }
        // }
        // return -1;
        
        // Optimal approach
        // TC - O(log n) * O(m)
        // SC - O(1)
        int low = 1, high = m;
        while(low<=high){
            int mid = low + ((high - low) / 2);
            int val = pow(mid,n,m);
            if(val==1){
               return mid; 
            }
            else if (val==0){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}