// Problem: https://leetcode.com/problems/sudoku-solve
class Solution {
    public boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == (char) (n + '0')) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (n + '0')) {
                return false;
            }
        }
        int nrow = (row / 3) * 3;
        int ncol = (col / 3) * 3;
        for (int i = nrow; i < nrow + 3; i++) {
            for (int j = ncol; j < ncol + 3; j++) {
                if (board[i][j] == (char) (n + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        if (row == board[0].length) {
            return true;
        }
        int nrow = 0;
        int ncol = 0;

        if (col != board[0].length - 1) {
            ncol=col+1;
            nrow = row;
        } else {
            ncol = 0;
            nrow=row+1;

        }

        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, nrow, ncol)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }

        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}