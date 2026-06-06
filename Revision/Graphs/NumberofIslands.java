package Revision.Graphs;

public class NumberofIslands {
    int[][] DIRECTIONS = {{-1,0} , {0,-1} , {1,0} , {0,1}};   // UP LEFT DOWN RIGHT

    // Number of Islands

    public void dfs(char[][] grid,int row,int col){

        // invalid co-ordinates
        if( row<0 || col<0 || row>=grid.length || col>= grid[0].length) return;

        if(grid[row][col] == '0') return;

        grid[row][col] = '0';

        for(int[] dirs : DIRECTIONS){
             dfs(grid,row+dirs[0],col+dirs[1]);
        }

    }
    public int numIslands(char[][] grid) {

        int islands = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
}
