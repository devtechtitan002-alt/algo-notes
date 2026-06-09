package Revision.DailyDose;

public class MaximumTotalSubarrayValueI {
    class Solution {

    public long maxTotalValue(int[] nums, int k) {

        long globalMax = Long.MIN_VALUE;
        long globalMin = Long.MAX_VALUE;

        for(int num : nums){
            globalMax = Math.max(globalMax,num);
            globalMin = Math.min(globalMin,num);
        }
        
        return k * (globalMax-globalMin);
    }
    }

}
