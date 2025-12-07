// Problem: https://www.geeksforgeeks.org/problems/toggle-bits-given-range0952/1

class Solution {
    static int toggleBits(int n, int l, int r) {

        for(int i = l - 1; i < r ; i++)
        {
            n = n ^ (1<<i);
        }
        
        return n;
    }
};