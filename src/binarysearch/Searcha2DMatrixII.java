// Problem: https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Brute force approach 
        // TC - O(m*n)
        // SC - O(1)
        // for(int i=0;i<matrix.length;i++){
        //     int count = 0;
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]==target){
        //             return true;
        //         }
        //     }
        // }

        // return false;

        // Better approach 
        // TC - O(m * log n)
        // SC - O(1)
        // int m = matrix.length;
        // int n = matrix[0].length;

        // for (int i = 0; i < m; i++) {
        //     int low = 0;
        //     int high = n - 1;

        //     while (low <= high) {
        //         int mid = low + ((high - low) / 2);
        //         if (matrix[i][mid] == target) {
        //             return true;
        //         } else if (matrix[i][mid] > target) {
        //             high = mid - 1;
        //         } else {
        //             low = mid + 1;
        //         }
        //     }
        // }

        // return false;

        // Optimal Approach
        // TC - O(m + n) because in the worst case, we traverse the entire first row and the entire last column.
        // SC - O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) { // Start the search from the top-right corner of the matrix.
            if (matrix[row][col] == target) {
                return true; // The target is found.
            }
            // If the current element is greater than the target,
            // it means all elements in the current column below this one are also greater.
            // So, we should move left to a smaller value in the current row.
            else if (matrix[row][col] > target) {
                col--;
            }
            // If the current element is less than the target,
            // it means all elements to the left in the current row are also smaller.
            // So, we should move down to a larger value in the next row.
            else {
                row++;
            }
        }
        return false;
    }
}