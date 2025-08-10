// Problem: https://leetcode.com/problems/rotate-image
class Solution {
    public void reverseRow(int[] row) {
        int start = 0;
        int end = row.length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[][] matrix) {
        // Brute force approach
        //  TC = O(n^2)
        //  SC = O(n^2)
        // int result[][] = new int[matrix.length][matrix.length];

        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix.length;j++){
        //         result[j][matrix.length-1-i]=matrix[i][j];
        //     }
        // }

        // Optimal approach
        //  TC = O(n/2 * n/2) + O(n * n/2)
        //  SC = O(1)
        int n = matrix.length;
        // Step 1: transpose matrix
        // Step 2: reverse each row
        // O(n/2)
        for (int i = 0; i < n - 1; i++) {
            // O(n/2)
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // O(n * n/2)
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }

    }
}