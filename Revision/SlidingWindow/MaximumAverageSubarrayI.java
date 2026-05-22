package Revision.SlidingWindow;

public class MaximumAverageSubarrayI {
    static class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // maximum sum
        double sum = 0,result=Integer.MIN_VALUE;
        int left=0;

        for(int right=0;right<nums.length;right++){
            
            sum += nums[right];

            if(right >= k-1){

                result = Math.max(result,sum);
                sum -= nums[left];
                left++;

            }
        }

        return (double)result/k;
    }
    }

     public static void main(String[] args){
         Solution sol = new Solution();
         System.out.println(sol.findMaxAverage(new int[]{-1},1));
    }
}
