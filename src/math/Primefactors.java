// Problem: https://www.geeksforgeeks.org/problems/prime-factors5052/1
class Solution {
    
      public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true; 
        if (n % 2 == 0) return false; 
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static ArrayList<Integer> primeFac(int n) {
        // Brute force approach
        // TC - O(sqrt(n) * (2*sqrt(n))) approx
        // SC - O(factors) // for returning the result
        // ArrayList<Integer> factors = new ArrayList<>();
        
        // for(int i=2;i*i<=n;i++){ // Check for all numbers from 2 to sqrt(n)
        //     if(n%i==0){
        //         if(isPrime(i)){
        //             factors.add(i);
        //         }
                
        //         if (n%(n/i) == 0){
        //             if(n/i!=i){
        //                 if(isPrime(n/i)){
        //                     factors.add(n/i);
        //                 }
        //             }
        //         }
        //     }
        // }
        
        //     // If n is still greater than 1, then it is a prime factor
        // if (n > 1 && isPrime(n)) {
        //     factors.add(n);
        // }

        
        // return factors;
        
        // Optimal approach
        // TC - O(sqrt(n) * log n) 
        // SC - O(factors) 
        ArrayList<Integer> factors = new ArrayList<>();
        
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                factors.add(i);
            }
            
            while(n%i==0){
                n = n/i;
            }
        }
   
        if (n!=1) {
            factors.add(n);
        }

        return factors;
    }
}

