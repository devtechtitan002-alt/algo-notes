import java.util.Arrays;
import java.util.Stack;
import java.util.HashMap;
public class NextGreaterElementI {
    static class Solution {
       public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer,Integer> mapForNums2 = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                mapForNums2.put(nums2[stack.pop()], nums2[i]); 
            }  
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i] = mapForNums2.getOrDefault(nums1[i],-1);
        }
        return result;
       }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(sol.nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4})));
    }
}
