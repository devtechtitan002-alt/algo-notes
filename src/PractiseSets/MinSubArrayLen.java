package PractiseSets;

public class MinSubArrayLen {
    static class Solution{
        public int minSubArrayLen(int target, int[] nums){

            int left=0,runningSum=0,minLen=Integer.MAX_VALUE;

            for(int right=0;right<nums.length;right++){
                 runningSum += nums[right];

                 while(runningSum >= target){
                    minLen = Math.min(minLen , ((right-left)+1));
                    runningSum -= nums[left];
                    left++;
                 }
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;

        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));
    }
}
