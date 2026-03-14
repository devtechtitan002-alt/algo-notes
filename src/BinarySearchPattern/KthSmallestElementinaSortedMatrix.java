import java.util.Arrays;
public class KthSmallestElementinaSortedMatrix {
    static class Solution {
    public int getRank(int[][] matrix,int target){
        int count=0;
        int row=matrix.length,col=matrix[0].length;
        for(int cols=0;cols<col;cols--){
            for(int rows=row-1;rows>=0;rows--){
                if(matrix[rows][cols]<=target){
                    count += row;
                    break;
                }
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
        int row=matrix.length,col=matrix[0].length;
        int[] left = {0,0};
        int[] right = {row-1,col-1};
        while(left[0]<=right[0] && left[1]<=right[1]){
            int midLeft=(left[0]+right[0])/2;
            int midRight=(left[1]+right[1])/2;
            int mid = matrix[midLeft][midRight];
            int rankOfMid = getRank(matrix,mid);
            if(rankOfMid < mid ){
                left[0]=midLeft+1;
                left[1]=midRight+1;
            }else{
                right[0]=midRight-1;
                right[1]=midRight-1;
            }
        }
        return matrix[left[0]][right[1]];
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }
}
