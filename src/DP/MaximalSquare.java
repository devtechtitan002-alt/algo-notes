package DP;

public class MaximalSquare {
    static class Solution {
    public int solve(char[][] grid,int i,int j){
           if(i<0||j<0||i>=grid.length||j>=grid[0].length) return 0;
           if(grid[i][j]=='0') return 0;
           return 1+Math.min(solve(grid,i-1,j-1),Math.min(solve(grid,i,j-1),solve(grid,i-1,j)));
    }
    public int maximalSquare(char[][] matrix) {
       int maxArea = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    int side=solve(matrix,i,j);
                    maxArea = Math.max(maxArea,side*side);
                }
            }
        }
        return maxArea;
    }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] grid = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        
        System.out.println(sol.maximalSquare(grid));
    }
}
