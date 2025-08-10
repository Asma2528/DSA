// Problem: https://leetcode.com/problems/transpose-matrix
class Solution {
    public int[][] transpose(int[][] matrix) {
        // TC - O(m*n)
        //  SC - O(m*n) For returning the result;
        int n=matrix.length;
        int m=matrix[0].length;
        int transpose[][]=new int[m][n];

        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }
}