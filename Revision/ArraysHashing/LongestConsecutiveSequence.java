package Revision.ArraysHashing;

import java.util.Set;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    static class Solution{
        public int longestConsecutive(int[] nums){
            Set<Integer> set = new HashSet<>();

            // remove duplicates here
            for(int num : nums){
                set.add(num);   
            }

            // start count for result when currNum -1 ia not in set that's where sequence starts
            int longestConseq = 0;
            for(int num : set){
                if(!set.contains(num-1)){
                    int count = 0;
                    int curr = num;
                    while(set.contains(curr)){
                        count++;
                        curr++;
                    }
                    longestConseq = Math.max(longestConseq,count);
                }
            }
            return longestConseq;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
