public class SearchIn2DMatrix {
    static class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow=-1,result=-1;
        int left=0,right=matrix.length-1,mid=0;
        while(left<=right){
            mid = left+((right-left)/2);
            int leftNum = matrix[mid][0];
            int rightNum = matrix[mid][matrix[mid].length-1];
            if(leftNum<=target && target<=rightNum){ 
                targetRow=mid;
                break;
            }
            else if(target>=rightNum){ 
                left=mid+1; 
            }
            else{ 
                right=mid-1; 
            }
        }
        if(targetRow==-1) return false;
        left = 0;
        right = matrix[targetRow].length-1;
        while(left<=right){
            mid = left+((right-left)/2);
            int currNum=matrix[targetRow][mid];
            if(currNum==target){ 
                result=mid;
                break;
            }
            else if(currNum<target){ 
                left=mid+1; 
            }
            else{ 
                right=mid-1; 
            }
        }
        return result!=-1;
        /*
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while(left <= right){

        int mid = left + (right-left)/2;

        int row = mid / cols;
        int col = mid % cols;

        int val = matrix[row][col];

        if(val == target) return true;

        else if(val < target)
           left = mid + 1;

        else
           right = mid - 1;
        }

        return false;
        */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] mat1 = {
            {1,3,5,7}, 
            {10,11,16,20}, 
            {23,30,34,60} 
        };
        System.out.println(sol.searchMatrix(mat1,3));
    }
}
}
