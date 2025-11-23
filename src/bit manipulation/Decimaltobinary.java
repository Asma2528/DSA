// Problem: https://www.geeksforgeeks.org/problems/decimal-to-binary-1610434291/1
public class Solution {
    public static void toBinary(int n) {
        if (n == 0) {
            System.out.println("0");
            return;
        }
        
        StringBuilder str = new StringBuilder();
        while(n > 0){
            str.append(n % 2);
            n /= 2;    
        }
        
        System.out.print(str.reverse());
    }
}
