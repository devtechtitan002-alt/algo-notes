package DP;
import java.util.Arrays;
public class UniquePathsII {
    class Solution {
        public int recursion(int[][] grid,int i,int row,int j,int col,int[][] dp){

        if( i == row-1 && j == col-1 ) {
            return (grid[i][j]!=1) ? 1 : 0;
        }

        if( i < 0 || j < 0 || i >= row || j >= col ) return 0;

        if(grid[i][j]==1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j] = recursion(grid,i,row,j+1,col,dp) + recursion(grid,i+1,row,j,col,dp);

        }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }
        return recursion(obstacleGrid,0,obstacleGrid.length,0,obstacleGrid[0].length,dp);
    }


    /*
    int[] dp = new int[n];

// start cell
dp[0] = (grid[0][0] == 1) ? 0 : 1;

for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){

        // blocked cell
        if(grid[i][j] == 1){
            dp[j] = 0;
        }
        // not blocked → update from left
        else if(j > 0){
            dp[j] = dp[j] + dp[j-1];
        }
    }
}

return dp[n-1];
 */
    }
}
