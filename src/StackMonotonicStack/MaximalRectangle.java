import java.util.*;

public class MaximalRectangle {
    static class Solution {

        public int maxArea(int[] heights){
            int[] newHeights = Arrays.copyOf(heights, heights.length + 1);
            newHeights[heights.length] = 0;

            Deque<Integer> stack = new ArrayDeque<>();
            int maxArea = 0;

            for(int i = 0; i < newHeights.length; i++) {
                while(!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int height = newHeights[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int width = i - left - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }

            return maxArea;
        }

        public int maximalRectangle(char[][] matrix) {
            if(matrix.length == 0) return 0;

            int cols = matrix[0].length;
            int[] heights = new int[cols];

            int maxArea = 0;

            for(int i = 0; i < matrix.length; i++) {

                // 🔥 build histogram
                for(int j = 0; j < cols; j++){
                    if(matrix[i][j] == '1'){
                        heights[j] += 1;
                    } else {
                        heights[j] = 0;
                    }
                }

                // 🔥 apply histogram logic
                maxArea = Math.max(maxArea, maxArea(heights));
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

        System.out.println(sol.maximalRectangle(grid));
    }
}