public class MaxAreaofIsland {
    static class Solution {
    public int dfsMaxArea(int[][] grid ,int row,int col){
        if( row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 ) return 0;

        grid[row][col] = 0; // marks as visited

        int[][] directions = { {1,0} , {0,1} , {-1,0} , {0,-1} };

        int area = 0;
        for(int[] dir : directions){
            area += dfsMaxArea(grid,row+dir[0],col+dir[1]);
        }

        return 1+area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea,dfsMaxArea(grid,i,j));
                }
            }
        }
        return maxArea;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid ={
           {0,0,1,0,0,0,0,1,0,0,0,0,0},
           {0,0,0,0,0,0,0,1,1,1,0,0,0},
           {0,1,1,0,1,0,0,0,0,0,0,0,0},
           {0,1,0,0,1,1,0,0,1,0,1,0,0},
           {0,1,0,0,1,1,0,0,1,1,1,0,0},
           {0,0,0,0,0,0,0,0,0,0,1,0,0},
           {0,0,0,0,0,0,0,1,1,1,0,0,0},
           {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int[][] grid1 = {
            {0,1,0,1,1,1},
            {0,1,0,0,0,1},
            {0,0,0,0,1,1}
        };
        System.out.println(sol.maxAreaOfIsland(grid1));
    }
}
