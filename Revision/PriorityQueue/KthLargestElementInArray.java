package Revision.PriorityQueue;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    static class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
    }
}
