package DP;
import java.util.Arrays;
public class UniquePaths {
    static class Solution {
    /*
        public int recursion(int i,int row,int j,int col){

        if( i == row-1 && j == col-1 ) return 1;

        if( i < 0 || j < 0 || i >= row || j >= col ) return 0;

        return recursion(i,row,j+1,col) + recursion(i+1,row,j,col);

        }

        public int uniquePaths(int m, int n) {

           return recursion(0,m,0,n);
        }

    */
    public int recursion(int i,int row,int j,int col,int[][] dp){

        if( i == row-1 && j == col-1 ) return 1;

        if( i < 0 || j < 0 || i >= row || j >= col ) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = recursion(i,row,j+1,col,dp) + recursion(i+1,row,j,col,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }

        return recursion(0,m,0,n,dp);

        /*
        int[][] dp = new int[m][n];

dp[0][0] = 1;

for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){

        if(i == 0 && j == 0) continue;

        int up = (i > 0) ? dp[i-1][j] : 0;
        int left = (j > 0) ? dp[i][j-1] : 0;

        dp[i][j] = up + left;
    }
}

return dp[m-1][n-1];
 */

        int[] dp = new int[n];
Arrays.fill(dp, 1);

for(int i = 1; i < m; i++){
    for(int j = 1; j < n; j++){
        dp[j] = dp[j] + dp[j-1];
    }
}

return dp[n-1];
    }

    


    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3,2));
    }
}
