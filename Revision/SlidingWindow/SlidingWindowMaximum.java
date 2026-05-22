package Revision.SlidingWindow;
import java.util.Queue;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    static class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length,resIdx=0,left=0;

        // deque for storing max values
        Deque<Integer> dq = new LinkedList<>();

        // result
        int[] res = new int[(n-k)+1];
 
        for(int right=0;right<nums.length;right++){

            // remove min values from end
            while(!dq.isEmpty() && nums[right] > nums[dq.peekLast()]) dq.removeLast();

            // add to last
            dq.addLast(right);

            if(right >= k-1){

                while(!dq.isEmpty() && dq.peekFirst() < left)  dq.removeFirst();
                
                res[resIdx++] = nums[dq.peekFirst()];

                left++;
            }

        }  

        return res;
    }
    }

    public static void main(String[] args){
         Solution sol = new Solution();
         System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1,-1},1)));
    }
}
