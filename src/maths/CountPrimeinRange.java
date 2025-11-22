// Problem: https://www.geeksforgeeks.org/problems/count-primes-in-range1604/1


class Solution {
    public boolean isPrime(int n) {
        // TC - O(sqrt(n))
        // SC - O(1)
        if (n == 1)
            return false;

        if (n == 2)
            return true;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    int countPrimes(int L, int R) {
        // Brute force approach
        // TC - O(sqrt(n) * n)
        // SC - O(1)

        // int count = 0;
        // for (int i = L; i <= R; i++) {
        //     if (isPrime(i)) {
        //         count++;
        //     }
        // }
        // return count;
        
        // Optimal approach using Sieve of Eratosthenes
        // TC - O(r log log r) + O(2r)
        // SC - O(r)
        if (R <= 2) {
            return 0;
        }

        int count = 0;
        boolean[] prime = new boolean[R + 1];

        
        for (int i = 2; i <= R; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= R; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= R; j += i) {
                    prime[j] = false;
                }
            }   
        }

        for (int i = L; i <= R; i++) {
            if (prime[i]) {
                count++;
            }
        }

        return count;
        
    }
};