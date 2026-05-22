package Revision.MonotonicStack;
import java.util.Deque;
import java.util.ArrayDeque;

public class LargestRectangleinHistogram {
    static class Solution{
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0, n = heights.length;

            // Stack for monotonic lengths of each rectangle until we get next small rectangle
            Deque<Integer> stack = new ArrayDeque<>();

            for(int i=0;i<heights.length;i++){

                while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                     int idx = stack.pop();
                     int prevSmaller = stack.isEmpty() ? -1 : stack.peek();
                     int width = i - prevSmaller - 1;
                     maxArea = Math.max(maxArea , heights[idx] * (width));

                }

                stack.push(i);
            }

            while(!stack.isEmpty()){
                int idx = stack.pop();
                int prevSmaller = stack.isEmpty() ? -1 : stack.peek();
                int width = n - prevSmaller - 1;                
                maxArea = Math.max(maxArea , heights[idx] * width);
            }

            return maxArea;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(new int[]{2,1,2}));
    }
}
