package DP;
import java.util.Arrays;
public class MinimumPathSum {

    static class Solution {

    //recursion
    /*
        public int minPathRecursion(int[][] grid,int r,int c){
        if(r==grid.length-1 && c==grid[0].length-1) return grid[r][c];
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return Integer.MAX_VALUE;
        return grid[r][c] + Math.min(minPathRecursion(grid,r,c+1),minPathRecursion(grid,r+1,c));
    }
    public int minPathSum(int[][] grid) {
        return minPathRecursion(grid,0,0);
    }
    */


    // memoization
    /*
    public int minPathRecursion(int[][] grid,int r,int c,int[][] dp){
        if(r==grid.length-1 && c==grid[0].length-1) return grid[r][c];
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return Integer.MAX_VALUE;
        if(dp[r][c]!=-1) return dp[r][c];
        return dp[r][c] = grid[r][c] + Math.min(minPathRecursion(grid,r,c+1,dp),minPathRecursion(grid,r+1,c,dp));
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }
        return minPathRecursion(grid,0,0,dp);
    }
    */

    // tabulation 
    /*
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp = new int[m][n];

dp[0][0] = grid[0][0];

for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){

        if(i == 0 && j == 0) continue;

        int up = (i > 0) ? dp[i-1][j] : Integer.MAX_VALUE;
        int left = (j > 0) ? dp[i][j-1] : Integer.MAX_VALUE;

        dp[i][j] = grid[i][j] + Math.min(up,left);
    }
}

return dp[m-1][n-1];
*/

public int minPathSum(int[][] grid) {
    int m=grid.length,n=grid[0].length;
           int[] dp = new int[n];
           for(int i=0;i<n;i++){
                dp[i] = i==0 ? grid[0][0] : Integer.MAX_VALUE;;
           }
          

for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){
        if(j>0)  dp[j] = grid[i][j] + Math.min(dp[j],dp[j-1]);
    }
    if(i<m-1) dp[0] += grid[i+1][0];
}

/*
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;

    int[] dp = new int[n];

    // initialize first row
    dp[0] = grid[0][0];
    for(int j = 1; j < n; j++){
        dp[j] = dp[j-1] + grid[0][j];
    }

    for(int i = 1; i < m; i++){
        // first column (only from top)
        dp[0] = dp[0] + grid[i][0];

        for(int j = 1; j < n; j++){
            dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
        }
    }

    return dp[n-1];
}
     */


return dp[n-1];
    }


    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}        
        };
        System.out.println(sol.minPathSum(grid));
    }
}
