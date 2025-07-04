// Problem: https://leetcode.com/problems/n-queens/
class Solution {

    public boolean isSafe(String[][] board, int row, int col){
        for(int i=0;i<board.length;i++){
            if(board[i][col].equals("Q")){
                return false;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[row][i].equals("Q")){
                return false;
            }
        }
        
        for(int nrow=row,ncol=col;ncol<board.length && nrow<board.length;nrow++,ncol++){
            if(board[nrow][ncol].equals("Q")){
                return false;
            }
        }

        for(int nrow=row,ncol=col;ncol>=0 && nrow<board.length;nrow++,ncol--){
            if(board[nrow][ncol].equals("Q")){
                return false;
            }
        }

        for(int nrow=row,ncol=col;ncol<board.length && nrow>=0;nrow--,ncol++){
            if(board[nrow][ncol].equals("Q")){
                return false;
            }
        }

        for(int nrow=row,ncol=col;ncol>=0 && nrow>=0;nrow--,ncol--){
            if(board[nrow][ncol].equals("Q")){
                return false;
            }
        }
        return true;
    }

    public void nQueens(List<List<String>> result,String[][] board,int row){
        if(row==board.length){
             List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                solution.add(String.join("", board[i])); 
            }
           result.add(solution);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]="Q";
                nQueens(result,board,row+1);
                 board[row][col]=".";
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        String[][] board=new String[n][n];
         
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        nQueens(result,board,0);

        return result;

    }
}