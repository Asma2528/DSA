// Problem: https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1
class Solution {
    static boolean armstrongNumber(int n) {
        int dup = n;
        int arm = 0, mod = 0;
        
        while(dup!=0){
            mod = dup%10;
            arm += mod*mod*mod;
            dup /= 10;
        }
        
        if(arm == n){
            return true;
        }
        
        return false;
    }
}