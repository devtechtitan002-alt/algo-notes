import java.util.Arrays;
public class KthSmallestElementinaSortedMatrix {
    static class Solution {
    public int getRank(int[][] matrix, int target){
    int count = 0;
    int row = matrix.length-1, col = 0;
    while(row >= 0 && col < matrix[0].length){
        if(matrix[row][col] <= target){
            count += row+1;  // entire column above included
            col++;           // move right
        } else {
            row--;           // move up
        }
    }
    return count;
}
    public int kthSmallest(int[][] matrix, int k) {
        /*
        int res=0;
        int[] result = new int[matrix.length*matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                result[res++] = matrix[i][j];
            }
        }
        Arrays.sort(result);
        return result[k-1];
        */
         int n = matrix.length;
    int lo = matrix[0][0];
    int hi = matrix[n-1][n-1];
    while(lo < hi){
        int mid = lo + (hi-lo)/2;
        if(getRank(matrix, mid) < k) lo = mid+1;
        else hi = mid;
    }
    return lo;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }
}
