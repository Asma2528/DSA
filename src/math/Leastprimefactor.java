// Problem: https://www.geeksforgeeks.org/problems/least-prime-factor5216/1
class Solution {
    public int[] getSieve(int n){
        int[] prime = new int[n+1];
        for(int i = 1; i <= n; i++){
            prime[i] = i;
        }
        

        for(int i = 2; i*i <= n; i++){
            if(prime[i] == i){
                for(int j = i*i; j<=n; j+=i){
                    if(prime[j] == j)
                    {
                        prime[j] = i;
                    }
                }
            }
        }
        
        return prime;
    }
    
    public int[] leastPrimeFactor(int n) {
       // TC - O(n log log n)
       // SC - O(n)
       
       return getSieve(n);
        
    }
}