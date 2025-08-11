// Problem: https://takeuforward.org/plus/dsa/problems/pascals-triangle-i
class Solution {
    // We solve this problem using nCr formula
    //  n! / (r! * (n-r)!)
    // TC - O(r)
    // SC - O(1)
    public int find_nCr(int r,int c){
        int result=1;
        for(int i=0;i<r;i++){
            result=result*(c-i);
            result=result/(i+1);
        }
        return result;
    }

    public int pascalTriangleI(int r, int c) {
        int value=find_nCr(r-1,c-1);
        return value;
    }
}