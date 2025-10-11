// Problem: https://www.geeksforgeeks.org/problems/prime-number2314/1
class Solution {
    static boolean isPrime(int n) {
        // TC - O(n)
        // SC - O(1)
        // if(n==1){
        //     return false;
        // }
        
        // int count = 0;
        // for(int i = 1;i<=n; i++){
        //     if(n%i==0){
        //         count++;
        //     }
        //     if(count>2){
        //         return false;
        //     }
        // }
        // return true;
        
        // TC - O(sqrt(n))
        // SC - O(1)
        if(n==1){
            return false;
        }
        
        int count = 0;
        for(int i = 1;i*i<=n; i++){
            if(n%i==0){
                count++;
            }
            if((n/i)!=i){
                if(n%(n/i)==0){
                    count++;
                }
            }
            
            if(count>2){
                return false;
            }
        }
        return true;
    }
}