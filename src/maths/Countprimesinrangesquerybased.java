// Problem: https://www.geeksforgeeks.org/dsa/count-primes-ranges/
import java.util.*;

// TC - O(2 maxR) + O(maxR log log maxR) + O(q)
// SC - O(maxR) + O(q)
class PrimeCounter {
    // This function generates a list of prime numbers up to a given integer n using the Sieve of Eratosthenes algorithm.
    public int[] getSieve(int n){
        // Optimal approach using Sieve of Eratosthenes
        // TC - O(n) + O(n log log n) 
        // SC - O(n)
        if (n <= 2) {
            return new int[]{0};
        }

        int count = 0;
        int[] prime = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            prime[i] = 1;
        }
        
        prime[0] = prime[1] = 0;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]==1) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }   
        }
        
        return prime;
    }
    
    // Method to count primes in each query range
    public List<Integer> countPrimes(List<int[]> queries) 
    {
        // Find the maximum value of R from the queries
        int maxR = 0;
        for (int[] query : queries) {
            maxR = Math.max(maxR, query[1]);
        }
        
        // Generate the sieve for the maximum R
        int[] prime = getSieve(maxR);
        
        // Build the prefix sum array (count of primes up to each number)
        // O(n)
        int cnt = 0;
        for (int i = 2; i <= maxR; i++) {
            cnt+=prime[i];
            prime[i] = cnt;
        }
        
        List<Integer> result = new ArrayList<>();
        
        // O(q)
        // Prepare the result for each query
        for(int i = 0; i<queries.size(); i++){
            int L = queries.get(i)[0];
            int R = queries.get(i)[1];
  
            result.add(prime[R] - prime[L-1]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        // List of queries with ranges
        List<int[]> queries = Arrays.asList(
            new int[]{3, 100},
            new int[]{8, 20},
            new int[]{1, 5}
        );

        
        // Output number of queries
        System.out.println("No. of Queries: " + queries.size());
        
        // Output query ranges
        System.out.print("Queries: ");
        for (int[] query : queries) {
            System.out.print("(" + query[0] + ", " + query[1] + ")  ");
        }
        
        PrimeCounter pc = new PrimeCounter();
        List<Integer> result = pc.countPrimes(queries);
        
        // Output prime counts
        System.out.println("\nNumber of primes between the ranges: " + result);
    }
}