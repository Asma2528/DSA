// Problem: https://leetcode.com/problems/search-a-2d-matrix/
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

        // Optimal approach 
        // TC - O(log m + log n)
        // SC - O(1)
        // int low = 0;
        // int high = matrix.length - 1;
        // int targetRow = -1;

        // while (low <= high) {
        //     int mid = low + ((high - low) / 2);

        //     if (matrix[mid][0] == target) {
        //         return true;
        //     } else if (matrix[mid][0] < target) {
        //         targetRow = mid;
        //         low = mid + 1;
        //     } else {
        //         high = mid - 1;
        //     }
        // }

        // if (targetRow == -1) { //  where the target is smaller than the first element of any row.
        //     return false;
        // }

        // low = 0;
        // high = matrix[0].length - 1;

        // while (low <= high) {
        //     int mid = low + ((high - low) / 2);
        //     if (matrix[targetRow][mid] == target) {
        //         return true;
        //     } else if (matrix[targetRow][mid] > target) {
        //         high = mid - 1;
        //     } else {
        //         low = mid + 1;
        //     }
        // }

        // return false;

        // Final Solution for TC - O(log(m X n))
        // Idea: Hypothetically converting 2d array into 1d array 
        // Converting middle index of 1d array into coordinates of 2d array
        // Formula: Row = index / no of rows 
        //          Column = index % no of rows
        // In 3 X 4 matrix if we want to find what is in 5th index of our hypothetic 1d array of (4*5 = 20 total elements)
        // Row = 5 / 4 = 1
        // Column = 5 % 4 = 1
        // Coordinates for 5th index is 1 X 1
        // Intution behid formula is the 1st row of the matrix is the multiple of the no of rows
        // If there are 4 rows then the 1st element of each row in of 2d matrix will be multiples of 4 of a 1d matrix
        int low = 0;
        int n = matrix[0].length;
        int high =(matrix.length * n) - 1;

        while(low<=high){
            int mid = low + ((high - low) / 2);
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return false;

    }
}