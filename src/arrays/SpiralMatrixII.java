// Problem: https://leetcode.com/problems/spiral-matrix-ii
class Solution {
    public int[][] generateMatrix(int n) {
        // TC - O(n*m)
        // SC - O(n*m) for returning the answer
        // It goes from right > bottom > left > top 
        int spiral[][]=new int[n][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int k=1;
        while (top <= bottom && left <= right) {
            // Go from left > right
            for (int i = left; i <= right; i++) {
                spiral[top][i]=k++;
            }
            top++;

            //  Go to top to bottom
            for (int i = top; i <= bottom; i++) {
               spiral[i][right]=k++;
            }
            right--;

            // Go from right to left
            if (top <= bottom) { // Edgecase: When there is 1 row
                for (int i = right; i >= left; i--) {
                    spiral[bottom][i]=k++;
                }
                bottom--;
            }

            // Go from bottom to top
            if (left <= right) { // Edgecase: When there is top row element is already printed
                for (int i = bottom; i >= top; i--) {
                    spiral[i][left]=k++;
                }
                left++;
            }
        }

        return spiral;
    }
}