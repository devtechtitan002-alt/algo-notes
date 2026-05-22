package Revision.ArraysHashing;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;


public class TopKFrequentElements {
    static class Solution{
        public int[] topKElements(int[] nums,int k){

            // getting frequency
            Map<Integer,Integer> map = new HashMap<>();
            for(int num : nums){
                if(map.containsKey(num)){
                    map.put(num,map.get(num)+1);
                }
                else{
                    map.put(num,1);
                }
            }

            /*
            // Use min-heap
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(a) - map.get(b)));
            for(int unique : map.keySet()){

               pq.add(unique);

               // maintain k-size min-heap
               while(pq.size() > k){
                  pq.poll();
               }

            }

            int[] res = new int[k];
            int i=0;

            while(!pq.isEmpty()){
                res[i++] = pq.poll();
            }
            
            // for(int i=0;i<res.length;i++){
            //     res[i] = pq.poll();
            // }

            return res;

            */

            // using bucket sort instead of min-heap
            List<Integer>[] buckets = new ArrayList[nums.length+1];

            // initialisation
            for(int i=0;i<=nums.length;i++){
                 buckets[i] = new ArrayList<>();
            }

            for(int key : map.keySet()){
                int freq = map.get(key);
                buckets[freq].add(key);
            }

            //walk through fro last becuase higher frequent elements 
            int[] result = new int[k];
            int idx = 0;
            for(int i=buckets.length-1;i>=0;i--){
                // individual buckets elements into result
                for(int num : buckets[i]){
                    result[idx++] = num;
                    if(idx == k) break;
                }
                if(idx == k) break;
            }

            return result;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.topKElements(new int[]{1,2,1,2,1,2,3,1,3,2},2)));
    }
}
