package Revision.MonotonicStack;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class NextGreaterElementII {
    static class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        // result array
        int[] result = new int[n];
        Arrays.fill(result,-1);

        // stack for unresolved waiting queue for less value elements
        Deque<Integer> stack = new ArrayDeque<>();

        // iterate twice becuase after last element iteration need once more for last element
        for(int i=0;i<2*n;i++){

            int idx = i%n;
 
            while(!stack.isEmpty() && nums[idx] > nums[stack.peek()]){
                result[stack.pop()] = nums[idx];
            }

            if(i<nums.length) stack.push(i);
        }

        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.nextGreaterElements(new int[]{1,2,1})));
    }
}
