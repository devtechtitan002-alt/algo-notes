package DP;

import java.util.Arrays;

public class MinimumFallingPathSum {
    static class Solution {

        /*
    public int recursion(int[][] matrix, int r, int c,int[][] dp){
    if(c < 0 || c >= matrix[0].length) return Integer.MAX_VALUE;

    if(r == matrix.length - 1) return matrix[r][c];

    if(dp[r][c]!=-1) return dp[r][c];

    int leftDiagonal = recursion(matrix, r+1, c-1,dp);
    int down = recursion(matrix, r+1, c,dp);
    int rightDiagonal = recursion(matrix, r+1, c+1,dp);

    int minCost = Math.min(down, Math.min(leftDiagonal, rightDiagonal));

    return dp[r][c] = matrix[r][c] + minCost;
    }


    public int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }        
        
        for(int j=0;j<matrix[0].length;j++){
           minSum = Math.min(minSum,recursion(matrix,0,j,dp));
        }
        return minSum;
    }

    */

    /*
    public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[][] dp = new int[n][n];

    // base case
    for(int j = 0; j < n; j++){
        dp[n-1][j] = matrix[n-1][j];
    }

    // build from bottom
    for(int i = n-2; i >= 0; i--){
        for(int j = 0; j < n; j++){

            int down = dp[i+1][j];
            int left = (j > 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
            int right = (j < n-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;

            dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
        }
    }

    int res = Integer.MAX_VALUE;
    for(int j = 0; j < n; j++){
        res = Math.min(res, dp[0][j]);
    }

    return res;
}
     */

       public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[] dp = new int[n];

    // base case
    for(int j = 0; j < n; j++){
        dp[j] = matrix[n-1][j];
    }

    // build from bottom
    for(int i = n-2; i >= 0; i--){
        for(int j = 0; j < n; j++){

            int down = dp[j];
            int left = (j > 0) ? dp[j-1] : Integer.MAX_VALUE;
            int right = (j < n-1) ? dp[j+1] : Integer.MAX_VALUE;

            dp[j] = matrix[i][j] + Math.min(down, Math.min(left, right));
        }
    }

    int res = Integer.MAX_VALUE;
    for(int j = 0; j < n; j++){
        res = Math.min(res, dp[j]);
    }

    return res;
}

/*
public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[] dp = new int[n];

    // base case
    for(int j = 0; j < n; j++){
        dp[j] = matrix[n-1][j];
    }

    // build from bottom
    for(int i = n-2; i >= 0; i--){
        for(int j = 0; j < n; j++){

            int down = dp[j];
            int left = (j > 0) ? dp[j-1] : Integer.MAX_VALUE;
            int right = (j < n-1) ? dp[j+1] : Integer.MAX_VALUE;

            dp[j] = matrix[i][j] + Math.min(down, Math.min(left, right));
        }
    }

    int res = Integer.MAX_VALUE;
    for(int j = 0; j < n; j++){
        res = Math.min(res, dp[j]);
    }

    return res;
     */


    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {-19,57},
            {-40,-5}        
        };
        System.out.println(sol.minFallingPathSum(grid));
    }
}
