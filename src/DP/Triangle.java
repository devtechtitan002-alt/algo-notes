package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    static class Solution {

    /*
    public int recursion(List<List<Integer>> triangle,int i,int listIdx,int[][] dp){
        if( listIdx==triangle.size() || i==triangle.get(i).size() ) return Integer.MAX_VALUE;
        if(dp[i][listIdx] != -1) return dp[i][listIdx];
        int minFromBelow = Math.min(recursion(triangle,i,listIdx+1,dp),recursion(triangle,i+1,listIdx+1,dp));
        return dp[i][listIdx] = triangle.get(listIdx).get(i) + (minFromBelow == Integer.MAX_VALUE ? 0 : minFromBelow);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }
        return recursion(triangle,0,0,dp);
    }
    */


    /*
    public int recursion(List<List<Integer>> triangle, int row, int col, int[][] dp){
    
    if(row == triangle.size() - 1)
        return triangle.get(row).get(col);

    if(dp[row][col] != -1)
        return dp[row][col];

    int down = recursion(triangle, row+1, col, dp);
    int diag = recursion(triangle, row+1, col+1, dp);

    return dp[row][col] = triangle.get(row).get(col) + Math.min(down, diag);
}
     */

    /*
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int lastChosen = 0;
        for(int i=1;i<n;i++){
            int j = lastChosen;
            int curr = triangle.get(i).get(lastChosen);
            int next = (triangle.get(i).size()>=2) ? triangle.get(i).get(lastChosen+1) : Integer.MAX_VALUE;
            int minToAdd = 0;
            if( curr < next){
                minToAdd = curr;
            }else{
                minToAdd = next;
                lastChosen = lastChosen+1;
            }
            dp[i][j] = dp[i-1][j] + minToAdd;
        }
        
        return dp[n-1][n-1];
    }
    */

    /*
    public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];

    dp[0][0] = triangle.get(0).get(0);

    for(int i = 1; i < n; i++){
        for(int j = 0; j <= i; j++){

            int up = (j < i) ? dp[i-1][j] : Integer.MAX_VALUE;
            int diag = (j > 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;

            dp[i][j] = triangle.get(i).get(j) + Math.min(up, diag);
        }
    }

    int res = Integer.MAX_VALUE;
    for(int j = 0; j < n; j++){
        res = Math.min(res, dp[n-1][j]);
    }

    return res;
}
     */


    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for(int j=0;j<triangle.get(n-1).size();j++){
            dp[j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
            int curr = dp[j];
            int next = dp[j+1];
            dp[j] = triangle.get(i).get(j)+ Math.min(curr,next);
            }
        }
        
        return dp[0];
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        List<List<Integer>> triangle = new ArrayList<>(Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3,4),
            Arrays.asList(6,5,7),
            Arrays.asList(4,1,8,3)
        ));
        System.out.println(sol.minimumTotal(triangle));
    }
}
