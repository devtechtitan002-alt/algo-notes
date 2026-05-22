package Revision.MonotonicStack;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

public class NextGreaterElementI {
    static class Solution{
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            // result array 
            int[] result = new int[nums1.length];

            // map for value -> next greater value
            Map<Integer,Integer> map = new HashMap<>();

            // stack for monotonicity
            Deque<Integer> stack = new ArrayDeque<>();
            
            for(int i=0;i<nums2.length;i++){
                while(!stack.isEmpty() && nums2[i] > stack.peek()){
                    map.put( stack.pop(),nums2[i]);
                }
                stack.push(nums2[i]);
            }

            for(int i=0;i<nums1.length;i++){
                result[i] = map.getOrDefault(nums1[i],-1);
            }

            return result;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.nextGreaterElement(new int[]{1,3,5,2,4},new int[]{6,5,4,3,2,1,7})));
    }
}
