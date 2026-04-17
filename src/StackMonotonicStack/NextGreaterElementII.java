import java.util.Arrays;
import java.util.Stack;
public class NextGreaterElementII {
    static class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length*2; i++){
            while(!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()]){
               res[stack.pop()] = nums[i%nums.length];
            }
            if(i < nums.length) stack.push(i);
        }
        while(!stack.isEmpty()) res[stack.pop()] = -1;
        return res;
    }
    /*
    import java.util.*;

public class NextGreaterElementII {
    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);

            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < 2 * n; i++) {
                int curr = nums[i % n];

                while (!stack.isEmpty() && curr > nums[stack.peek()]) {
                    res[stack.pop()] = curr;
                }

                if (i < n) stack.push(i);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.nextGreaterElements(new int[]{5,4,3,2,1})));
    }
} */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        //System.out.println(Arrays.toString(sol.nextGreaterElements(new int[]{1,2,1})));
        //System.out.println(Arrays.toString(sol.nextGreaterElements(new int[]{4,2,5,1,8,9,4,5})));
        System.out.println(Arrays.toString(sol.nextGreaterElements(new int[]{5,4,3,2,1})));
    }
}
