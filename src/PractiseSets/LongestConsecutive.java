package PractiseSets;

import java.util.Set;
import java.util.HashSet;

public class LongestConsecutive {
    static class Solution{
        public int longestConsecutive(int[] nums){
            Set<Integer> set = new HashSet<>();
            for(int num : nums)
                set.add(num);
            

            // len count 
            int maxLen=0;

            for(int num : set){

                if(!set.contains(num-1)){

                    int len=1;
                    int curr = num;

                    while(set.contains(curr+1)) {
                        len++;
                        curr=curr+1;
                    }

                    maxLen = Math.max(len,maxLen);
                }
            }

            return maxLen;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
