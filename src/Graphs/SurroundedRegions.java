import java.util.Arrays;
public class SurroundedRegions {
    static class Solution {
    int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(char[][] board,int row,int col){

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;

        if(board[row][col]=='X') return;
     
        if(board[row][col]=='O'){

            board[row][col] = '-';

            for(int[] dir : DIRECTIONS ){
                dfs(board,row+dir[0],col+dir[1]);
            }

        }

    }
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }

        for(int j=0;j<col;j++){
            dfs(board,0,j);
            dfs(board,row-1,j);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X') continue;
                if(board[i][j]=='O') board[i][j] = 'X';
                if(board[i][j]=='-') board[i][j] = 'O';                
            }
        }
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        char[][] board = {
           {'O','X','O'},
           {'X','O','X'},
           {'O','X','O'},
           //{'X','O','X','X'}
        };
        sol.solve(board);
        for(char[] row : board){
           System.out.println(Arrays.toString(row));
        }
    }
}
