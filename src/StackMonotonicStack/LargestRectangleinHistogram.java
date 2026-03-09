import java.util.Stack;
public class LargestRectangleinHistogram {
    static class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int right=0;right<heights.length;right++){
           while(!stack.isEmpty() && heights[right] < heights[stack.peek()]){
             int height = heights[stack.pop()];
             int left = stack.isEmpty() ? -1 : stack.peek();
             int width = right-left-1;
             maxArea = Math.max(maxArea,width*height);
           }
           stack.push(right);
        }
        int n = heights.length;

        while(!stack.isEmpty()) {

            int height = heights[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = n - left - 1;

            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
        /*
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
         */
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(sol.largestRectangleArea(new int[]{2,4}));
    }

}
