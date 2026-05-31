package Revision.BinarySearch;

public class Searcha2DMatrix {
    static class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n=matrix[0].length;  // since each row first element is greater than previous rows last element we treated it as 1d arraY
        int l=0,r=m*n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int row = mid/n;
            int col = (mid - (n*(mid/n)));

            if(matrix[row][col] == target) return true;

            if(matrix[row][col] < target) l = mid+1;
            else r = mid-1;

        }
        return false;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
           {1,3,5,7},
           {10,11,16,20},
           {23,30,34,60}
        };
        System.out.println(sol.searchMatrix(grid,19));
    }
}
