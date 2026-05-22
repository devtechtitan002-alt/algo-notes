package Revision.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinaStream {
    static class KthLargest {

    // there is 2 heaps one is k sized min-heap anopther one is dynamic size max-heap
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int size;

    public KthLargest(int k, int[] nums) {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b)->(b-a));
        size = k;

        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {

        if(min.size() < size){
            min.add(val);
            return min.peek();
        }

        // maintain k size min-heap
        if(!min.isEmpty() && val >= min.peek()){
            max.add(min.poll());
            min.add(val);
        }

        return min.peek();   // we need to given top kth score in O(1) so we need two heaps
    }

    }

    public static void main(String[] args){
        KthLargest sol = new KthLargest(2,new int[]{0});
       // System.out.println(sol.add(0));
        System.out.println(sol.add(-1));
        // System.out.println(sol.add(10));
        // System.out.println(sol.add(9));
        // System.out.println(sol.add(4));

        
    }
}
