package Revision.Graphs;
import java.util.Arrays;

public class SurroundedRegions {
    static class Solution {

    int[][] DIRECTIONS = { {-1,0} , {0,-1} , {1,0} , {0,1} };

    public void dfs(int row,int col,char[][] board){
        
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;

        if(board[row][col] == 'X' || board[row][col] == '-') return;

        if(board[row][col] == 'O') board[row][col] = '-';

        for(int[] dirs : DIRECTIONS){
            dfs(row+dirs[0],col+dirs[1],board);
        }
    }

    public void solve(char[][] board) {

        // make dfs call for 4 borders for given grid to make o's neighbours into '-'

        // left and right
        for(int i=0;i<board.length;i++){
            dfs(i,0,board);
            dfs(i,board[0].length-1,board);
        }

        // top and bottom
        for(int j=0;j<board[0].length;j++){
            dfs(0,j,board);
            dfs(board.length-1,j,board);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                 if(board[i][j] == 'O') board[i][j] = 'X';
                 if(board[i][j] == '-') board[i][j] = 'O';                
            }
        }
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        char[][] grid = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };

        char[][] grid1 = {
            {'X','O','X'},
            {'O','X','O'},
            {'X','O','X'}
        };

        sol.solve(grid1);

        for(char[] board : grid1){
            System.out.println(Arrays.toString(board));
        }
    }
}
