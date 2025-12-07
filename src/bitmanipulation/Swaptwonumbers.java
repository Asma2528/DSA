// Problem: https://www.geeksforgeeks.org/problems/swap-two-numbers3844/1
class Solution {
    static List<Integer> get(int a, int b) {
      // TC = O(1)
      // SC = O(1)
       a = a ^ b;
       b = a ^ b;
       a = a ^ b;
       
       return Arrays.asList(a, b);
        
    }
}