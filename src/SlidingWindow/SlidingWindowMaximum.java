import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
public class SlidingWindowMaximum {
    static class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[(nums.length-k)+1];
        int idx=0,left=0;
        for(int right=0;right<nums.length;right++){
            while(!q.isEmpty() && nums[right] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(right);
            if(right>=k-1){
               res[idx++]=nums[q.peekFirst()];
               left++;
               if(q.peekFirst()<left) q.pollFirst();
            }
        }
        return res;
    }

    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> q = new ArrayDeque<>();
    int[] res = new int[nums.length - k + 1];
    int idx = 0;

    for (int right = 0; right < nums.length; right++) {

        // 1. Remove smaller elements from back
        while (!q.isEmpty() && nums[right] > nums[q.peekLast()]) {
            q.pollLast();
        }

        // 2. Add current index
        q.addLast(right);

        // 3. Remove out-of-window elements from front
        if (q.peekFirst() <= right - k) {
            q.pollFirst();
        }

        // 4. Take result
        if (right >= k - 1) {
            res[idx++] = nums[q.peekFirst()];
        }
    }

    return res;
}
     */
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }
}
}
