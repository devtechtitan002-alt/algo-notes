package Revision.Graphs;

public class MaxAreaofIsland {
    class Solution {

        int[][] DIRECTIONS = {{-1,0} , {0,-1} , {1,0} , {0,1}};   // UP LEFT DOWN RIGHT

    public int dfs(int[][] grid,int row,int col){

        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return 0;

        if(grid[row][col] == 0) return 0;

        grid[row][col] = 0;  

        int area = 0;

        for(int[] dirs : DIRECTIONS){
            area += dfs(grid,row+dirs[0],col+dirs[1]);
        }

        return 1+area;  // we assign 0 to current land so that was added here
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea , dfs(grid,i,j));
                }
            }
        }
        return maxArea;

    }
}
}
