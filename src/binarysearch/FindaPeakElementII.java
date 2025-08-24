// Problem: https://leetcode.com/problems/find-a-peak-element-ii/
class Solution {
    public int maxElementInColumn(int[][] mat, int m, int n, int col) {
        int maxVal = -1;
        int maxRow = -1;
        for (int i = 0; i < m; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                maxRow = i;
            }
        }
        return maxRow;
    }

    public int[] findPeakGrid(int[][] mat) {
        // Brute force approach
        // TC - O(m*n)
        // SC - O(1)
        // int m = mat.length;
        // int n = mat[0].length;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         boolean isPeak = true;

        //         // Check top neighbor
        //         if (i > 0 && mat[i][j] <= mat[i - 1][j]) {
        //             isPeak = false;
        //         }
        //         // Check bottom neighbor
        //         if (i < m - 1 && mat[i][j] <= mat[i + 1][j]) {
        //             isPeak = false;
        //         }
        //         // Check left neighbor
        //         if (j > 0 && mat[i][j] <= mat[i][j - 1]) {
        //             isPeak = false;
        //         }
        //         // Check right neighbor
        //         if (j < n - 1 && mat[i][j] <= mat[i][j + 1]) {
        //             isPeak = false;
        //         }

        //         if (isPeak) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{-1, -1};

        // Optimal approach
        // TC - O(m * log n)
        // SC - O(1)
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int row = maxElementInColumn(mat, m, n, mid);

            // Get the values of the left and right neighbors, handling boundaries
            int left = (mid > 0) ? mat[row][mid - 1] : -1;
            int right = (mid < n - 1) ? mat[row][mid + 1] : -1;
            if ((mat[row][mid] > left) && (mat[row][mid] > right)) {
                return new int[] { row, mid }; // Found a peak
            } else if (right > mat[row][mid]) {
                // The peak is in the direction of the larger neighbor.
                // If the right neighbor is greater, move right.
                low = mid + 1;
            } else {
                // If the left neighbor is greater (or equal), move left.
                high = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }
}