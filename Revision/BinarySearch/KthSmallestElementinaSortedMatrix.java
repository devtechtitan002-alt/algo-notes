package Revision.BinarySearch;

public class KthSmallestElementinaSortedMatrix {
    static class Solution {

        /*
        public int getRank(int[][] mat,int target){
        int rank = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=mat[0].length-1;j>=0;j--){
               if(mat[i][j] <= target){
                  rank += (j+1);
                  break;
               }
            }
        }
        return rank;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int result = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(getRank(matrix,matrix[i][j]) >= k){
                    result = Math.min(result,matrix[i][j]);
                }
            }
        }
        return result;
    }
         */


    public int getRank(int[][] mat,int target){
        int rank = 0;
        int row = 0,col=mat[0].length-1;
        while(row < mat.length && col >= 0){
           if(mat[row][col] <= target){
              rank += col+1;
              row++;
           }else{
              col--;
           }
        }
        return rank;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int left=matrix[0][0] , right = matrix[matrix.length-1][matrix[0].length-1];
        while(left<right){
            int mid = left + (right-left)/2;
            int rank = getRank(matrix,mid);
            if(rank < k){
                left = mid+1;
            }else{
                right=mid;
            }
        }
        return right;  // even left also right becuase stops at right==left
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] mat = {
            {1,5,9},
            {10,11,13},
            {12,13,15}
        };
        System.out.println(sol.kthSmallest(mat,8));
    }
}
