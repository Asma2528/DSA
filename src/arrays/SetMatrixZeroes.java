// Problem: https://leetcode.com/problems/set-matrix-zeroes
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // Brute force approach
        // But below approach will only work is negetive values are not stored in the matrix
        //  TC - O(n*m) + O(n+m) + O(n*m)
        //  SC - O(1)

        // O(n*m)
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         // O(n+m)
        //         if (matrix[i][j] == 0) {
        //             for (int k = 0; k < m; k++) {
        //                 if (matrix[k][j] != 0) {
        //                     matrix[k][j] = -1;
        //                 }
        //             }
        //             for (int k = 0; k < n; k++) {
        //                 if (matrix[i][k] != 0) {
        //                     matrix[i][k] = -1;
        //                 }
        //             }
        //         }
        //     }
        // }

        // // O(n*m)
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == -1) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        // Better approach
        // TC - O(2*m*n)
        // SC - O(m+n)
        // int[] row = new int[m];
        // int[] col = new int[n];

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == 0) {
        //             row[i] = 1;
        //             col[j] = 1;
        //         }
        //     }
        // }

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (row[i] == 1 || col[j] == 1) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        // Optimal approach
        // TC - O(2*m*n)
        // SC - O(1)
        int col0 = 1;
        // Step 1: Mark the first row/column if zero found.  If in col 0 zero is found will store it in col0.
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                col0 = 0; // mark first column separately
            for (int j = 1; j < n; j++) { // start from column 1
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Apply markers to set zeroes
        for (

                int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Place Zero in first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Place Zero in first column if needed
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}