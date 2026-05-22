package Revision.PriorityQueue;

import java.util.PriorityQueue;

public class LastStoneWeight {
    static class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size() > 1){
            int x = pq.poll();

            if(pq.isEmpty()) break;

            int y = pq.poll();

            if( x == y ) continue;

            pq.add(x-y);
        }

        return !pq.isEmpty() ? pq.peek() : 0;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        
    }
}
