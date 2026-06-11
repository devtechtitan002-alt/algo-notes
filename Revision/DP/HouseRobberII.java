package Revision.DP;

import java.util.Arrays;

public class HouseRobberII {
     static class Solution{
     public int recurse(int[] nums,int idx,int e,int[] dp){
        if(idx >= e) return 0;

        if(dp[idx] != -1) return dp[idx];
        
        int doRob = recurse(nums,idx+2,e,dp);

        int skipRob = recurse(nums,idx+1,e,dp);

        return dp[idx] = Math.max(nums[idx]+doRob , skipRob);
     }
     public int rob(int[] nums) {
         if(nums.length==1) return nums[0];
         int[] dp = new int[nums.length];

         Arrays.fill(dp,-1);
         int startAtZero  = recurse(nums,0,nums.length-1,dp);

         Arrays.fill(dp,-1);
         int startAtFirst = recurse(nums,1,nums.length,dp);

         return Math.max(startAtZero,startAtFirst);
     }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{1,2,3,1}));
    }
}
