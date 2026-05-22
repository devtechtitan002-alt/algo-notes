package Revision.MonotonicStack;
import java.util.Deque;
import java.util.ArrayDeque;

public class Maximalrectangle {
    static class Solution {
    public int largestRectangle(char[] heights){
        int maxArea=0,n=heights.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int right=0;right<heights.length;right++){
           
            while(!stack.isEmpty() && heights[right]-'0' < heights[stack.peek()]-'0'){
                
                int length = heights[stack.pop()]-'0';
                int previousSmaller = stack.isEmpty() ? -1 : stack.peek();
                int width = right - previousSmaller -1;
                maxArea = Math.max(maxArea, length*width);
            }
            
            stack.push(right);
        }

        while(!stack.isEmpty()){
            int length = heights[stack.pop()]-'0';
            int previousSmaller = stack.isEmpty() ? -1 : stack.peek();
            int width = n - previousSmaller -1;
            maxArea = Math.max(maxArea, length*width);
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {

        int maxArea = 0;

        maxArea = Math.max(maxArea , largestRectangle(matrix[0]));

        for(int i=1;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){

                int a = matrix[i][j]-'0';
                int b = matrix[i-1][j]-'0'; 

                if(a>=1  && b>=1){
                   matrix[i][j] = (char)((a+b)+'0');
                }

            }

            maxArea = Math.max(maxArea , largestRectangle(matrix[i]));
        }

        return maxArea;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        char[][] grid = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        //char[][] grid = {{'0','1'},{'1','0'}};
        System.out.println(sol.maximalRectangle(grid));
    }
}
