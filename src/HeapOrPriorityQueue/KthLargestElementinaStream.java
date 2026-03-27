import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
public class KthLargestElementinaStream {
    static class KthLargest {

    PriorityQueue<Integer> temp = new PriorityQueue<Integer>((a,b)->b-a);
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a-b);
    int kth = -1;

    public KthLargest(int k, int[] nums) {
        kth = k;
        if( nums.length == 0 ) return;
        if( nums.length < k){
            for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            }
            return;
        }
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            int num = nums[i];
            if(num > pq.peek()){
                temp.add(pq.poll());
                pq.add(num);   
            }else{
                temp.add(num);
            }
        }
    }
    
    public int add(int val) {

        if( pq.size() >= kth ){
            if(val>pq.peek()){
            temp.add(pq.poll());
            pq.add(val); 
            }else{
            temp.add(val);
            }
        }else{
            pq.add(val);
        }
        return pq.peek();
    }

    /*
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap only

public KthLargest(int k, int[] nums){
    this.k = k;
    for(int num : nums) add(num);
}

public int add(int val){
    pq.add(val);
    if(pq.size() > k) pq.poll(); // remove smallest
    return pq.peek();            // top = kth largest
}
 */
    }
    public static void main(String[] args){
        KthLargest kl = new KthLargest(2,new int[]{0});
        System.out.println(kl.pq);
        System.out.println(kl.add(-1));
        System.out.println(kl.pq);
        System.out.println(kl.add(1));
        System.out.println(kl.pq);
        System.out.println(kl.add(-2));
        System.out.println(kl.pq);
        System.out.println(kl.add(-4));
        System.out.println(kl.pq);
        System.out.println(kl.add(3));
        System.out.println(kl.pq);
    }
}
