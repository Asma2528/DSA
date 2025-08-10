// Problem: https://leetcode.com/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Purpose: Implementation skills and how clean you write the code
        // TC - O(n*m)
        // SC - O(n*m) for returning the answer
        // It goes from right > bottom > left > top 
        List<Integer> spiral = new ArrayList<>();
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (top <= bottom && left <= right) {
            // Go from left > right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;

            //  Go to top to bottom
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            // Go from right to left
            if (top <= bottom) { // Edgecase: When there is 1 row
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Go from bottom to top
            if (left <= right) { // Edgecase: When there is top row element is already printed
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiral;
    }
}