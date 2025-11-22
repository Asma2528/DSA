// Problem: https://www.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/
class Solution {
    public int[] sieve(int n) {
        // TC - O(n log log n) + O(3n)
        // SC - O(n)
       
        // Edge case for n < 2
        if (n < 2) {
            return new int[0]; // No primes less than 2
        }
        
        
       // Boolean array to store the primality of each number
       boolean[] prime = new boolean[n+1];
       
       // Initialize all numbers as prime (true means prime)
       // O(n)
       for(int i = 2; i<=n; i++){
           prime[i] = true;
       }
       
       // Sieve of Eratosthenes
       for(int i = 2; i*i<=n; i++)
       {
           if(prime[i]){
               for(int j = i*i; j<=n ; j+=i){
                   prime[j] = false;
               }
           }
       }
       
       // O(n)
       int len = 0;
       for(int i = 2; i<=n; i++){
           if(prime[i]){
               len++;
           }
       }
       
       // O(n)
       int[] result = new int[len];
       int j = 0;
       for(int i = 2; i<=n; i++){
           if(prime[i]){
               result[j++] = i;
           }
       }
 
       return result;
       
        
    }
}