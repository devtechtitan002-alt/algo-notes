import java.util.PriorityQueue;
public class KthLargestElementinanArray {
    static class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num : nums) pq.add(num);
        for(int i=0;i<k-1;i++) pq.poll();
        return pq.peek();
        /*
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.add(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }    
    return minHeap.peek();
     */   
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}
