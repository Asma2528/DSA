// Problem: https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1
class Solution {
    public static void print_divisors(int n) {
        // Brute force approach
        // TC - O(n)
        // SC - O(1)
        // for(int i=1;i<=n;i++){
        //     if(n % i == 0){
        //         System.out.print(i + " ");
        //     }
        // }
        
        
        // Optimal Approach
        // TC - O(sqrt(n) + d log n)
        // SC - O(d) - where d is divisors
        
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i=1;i*i<=n;i++){ // 
            if(n % i == 0){
                divisors.add(i);
                
                if((n/i)!=i){
                    divisors.add(n/i);   
                }
            }
        }
        
        Collections.sort(divisors);
        
        for(int i=0;i<divisors.size();i++){
            System.out.print(divisors.get(i) + " ");
        }
    }
}
