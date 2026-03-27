import java.util.PriorityQueue;
import java.util.Collections;
public class LastStoneWeight {
    static class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) pq.add(stone);
        while(!pq.isEmpty() && pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if( x == y ) continue;
            pq.add(x-y);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
