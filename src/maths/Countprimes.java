// Problem: https://leetcode.com/problems/count-primes/
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

    public int countPrimes(int n) {
        // Brute force approach
        // TC - O(sqrt(n) * n)
        // SC - O(1)

        // int count = 0;
        // for (int i = 2; i < n; i++) {
        //     if (isPrime(i)) {
        //         count++;
        //     }
        // }
        // return count;

        // Optimal approach using Sieve of Eratosthenes
        // TC - O(n log log n) + O(2n)
        // SC - O(n)
        if (n <= 2) {
            return 0;
        }

        int count = 0;
        boolean[] prime = new boolean[n];

        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }

        return count;
    }
}