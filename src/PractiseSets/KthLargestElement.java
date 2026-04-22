package PractiseSets;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
public class KthLargestElement {
    static class Solution{
        public int kthLargest(int[] nums,int k){

            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b); // by default also its been ascending order

            for(int num : nums){
                minHeap.add(num);
                if(minHeap.size() > k) minHeap.poll();
            }

            return minHeap.peek();
        }
    }

    
}
