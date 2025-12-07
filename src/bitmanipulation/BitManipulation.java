// Problem: https://www.geeksforgeeks.org/problems/bit-manipulation-1666686020/1

class Solution {
    static void bitManipulation(int num, int i) {
        i -= 1;
        
        int getBit = 0;
        if((num&(1<<i))!=0){
            getBit = 1;
        }
        
        int setBit = num | (1 << i);
        
        int clearBit = num & (~(1 << i));
        
        System.out.print(getBit+" "+setBit+" "+clearBit);
        
    }
}
