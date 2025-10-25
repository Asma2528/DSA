// Problem: https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1
class Solution {
    public static int gcd(int a, int b) {
        // Brute force approach
        // TC - O(min(a,b))
        // SC - O(1)
        // int result = 0;
        
        // for(int i=Math.min(a,b);i>=1;i--){
        //     if(a%i==0 && b%i==0){
        //         result = i;
        //         break;
        //     }
        // }        
        // return result;
        
        // Optimal approach (Using Euclidean Algorithm)
        // TC - O(log of phi (min(a,b))) - phi because each time we are diving with a different number
        // SC - O(1) 
        /*
        Euclidean Algorithm -
        gcd(a,b) = gcd(a-b, b) where a > b
        gcd(a,b) = gcd(a%b, b) where a > b
        */
        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }
            else{
                b=b%a;
            }
        }
        
        if(a==0){
            return b;
        }
        
        return a;
    }
}
