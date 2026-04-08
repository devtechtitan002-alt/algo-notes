package DP;
import java.util.Arrays;
public class TargetSum {
    static class Solution {
    /*
    public int recursion(int[] nums,int i,int currsum,int target){
        if(i==nums.length) return currsum == target ? 1 : 0;
        return recursion(nums,i+1,currsum+nums[i],target) + recursion(nums,i+1,currsum-nums[i],target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] < target) return 0; 
        return recursion(nums,0,0,target);
    }
    */

    public int recursion(int[] nums,int i,int currsum,int target,int[][] dp){
        if(i==nums.length) return currsum == target ? 1 : 0;
        if(currsum>target) return 0;
        if(dp[i][currsum]!=-1) return dp[i][currsum];
        return dp[i][currsum] = recursion(nums,i+1,currsum+nums[i],target,dp) + recursion(nums,i+1,currsum,target,dp);
    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0) return 0;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if((totalSum+target)%2 != 0) return 0;

        int targetForRecursion = (totalSum+target)/2;

        /*
        int[][] dp = new int[nums.length][targetForRecursion+1];

        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }

        return recursion(nums,0,0,targetForRecursion,dp);
        */

        int[] dp = new int[targetForRecursion + 1];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++){
           for(int s = target; s >= nums[i]; s--){
              dp[s] += dp[s - nums[i]];
           }
        }

        return dp[targetForRecursion];
    } 

    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
