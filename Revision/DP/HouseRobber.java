package Revision.DP;
import java.util.Arrays;

public class HouseRobber {
    static class Solution{

        public int recurse(int idx,int[] nums,int[] dp){

            if(idx < 0) return 0;

            if(dp[idx] != -1) return dp[idx];

            int take = idx > 1 ? recurse(idx-2,nums,dp) : 0;

            int skip = idx > 0 ? recurse(idx-1,nums,dp) : 0;

           return dp[idx] = Math.max(nums[idx]+take,skip);
        }

        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp,-1);
            return recurse(nums.length-1,nums,dp);
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{100,1,1,100}));
    }
}
