package PractiseSets;

import java.util.List;
import java.util.ArrayList;

public class MissingRange {
    static class Solution{
        public List<String> findMissingRanges(int[] nums, int lower, int upper){
            List<String> res = new ArrayList<>();
            int prev = lower;
            for(int i=0;i<nums.length;i++){
                int curr = nums[i];
                if((curr - prev) > 1){
                    int start = prev+1;
                    int end = curr-1;
                    if(end-start > 0){
                        res.add(String.valueOf(start) + "->" + String.valueOf(end));
                    }else{
                        res.add(String.valueOf(start));
                    }
                }
                prev = curr;
            }

            // handle upper bound 
            int start = prev+1;
            int end = upper;
            if(end-start > 0){
                res.add(String.valueOf(start) + "->" + String.valueOf(end));
            }else{
                res.add(String.valueOf(start));
            }


            return res;


            /*
            
            public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList<>();

    long prev = (long) lower - 1;

    for (int num : nums) {

        if (num < lower) continue;
        if (num > upper) break;

        if ((long) num - prev > 1) {
            res.add(format(prev + 1, num - 1));
        }

        prev = num;
    }

    if ((long) upper - prev >= 1) {
        res.add(format(prev + 1, upper));
    }

    return res;
}

private String format(long start, long end) {
    if (start == end) return String.valueOf(start);
    return start + "->" + end;
}
    
*/
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMissingRanges(new int[]{0,1,3,50,75},0,99));
    }
}
