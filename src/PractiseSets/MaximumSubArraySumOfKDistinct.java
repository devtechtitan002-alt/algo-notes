package PractiseSets;
import java.util.Set;
import java.util.HashSet;

public class MaximumSubArraySumOfKDistinct {

    static class Solution{
        public long maximumSubarraySum(int[] nums, int k){
            int runningSum = 0,left = 0;
            long maxSum = Long.MIN_VALUE;
            Set<Integer> set = new HashSet<Integer>();
            for(int right=0;right<nums.length;right++){

                //duplicates handling
                while(!set.isEmpty() && set.contains(nums[right])){
                    set.remove(nums[left]);
                    runningSum -= nums[left];
                    left++;
                }

                // add current num
                runningSum += nums[right];
                set.add(nums[right]);

                // maintain size
        if (right - left + 1 > k) {
            set.remove(nums[left]);
            runningSum -= nums[left];
            left++;
        }

        // valid window
        if (right - left + 1 == k) {
            maxSum = Math.max(maxSum, runningSum);
        }
            }
            return maxSum;
        }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maximumSubarraySum(new int[]{1,5,4,2,9,9,9},3));
    }
}
