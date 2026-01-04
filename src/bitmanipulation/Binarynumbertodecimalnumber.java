// Problem: https://www.geeksforgeeks.org/problems/binary-number-to-decimal-number3525/1

class Solution {
    public int binaryToDecimal(String b) {
        int pow = 1;
        int n = 0;
        
        for(int i = b.length() - 1; i>=0; i--){
            if(b.charAt(i)=='1'){
                n += Character.getNumericValue(b.charAt(i))*pow;
            }
            pow *= 2;
        }
        
        return n;
    }
}