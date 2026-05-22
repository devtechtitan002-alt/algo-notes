package Revision.SortingAlgos;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    static class Solution{
        public int[] bucketSort(int[] nums){

           int[] res = new int[nums.length];

           // buckets allocation
           List<Integer>[] buckets = new ArrayList[10];  // least-significant bit

           // buckets initialisation
           for(int i=0;i<buckets.length;i++){
              buckets[i] = new ArrayList<>();
           }

           // allocate fit numbers into corresponding buckets
           for(int num : nums){
              buckets[num%10].add(num);
           }

           // sort individual bucket
           for(int i=0;i<buckets.length;i++){
              if(buckets[i].size() > 1) Collections.sort(buckets[i]);
           }

           // res building
           int idx = 0;
           for(int i=0;i<buckets.length;i++){
            
              for(int j=0;j<buckets[i].size();j++){
                  res[idx++] = buckets[i].get(j);
                  buckets[i].get(j);
              }

           }

           return res;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = new int[]{5,4,1,3,2};
        int[] sortedNums = sol.bucketSort(nums);
        System.out.println(Arrays.toString(sortedNums));
    }
}
