package DP;
import java.util.Arrays;
public class PartitionEqualSubsetSum {
    static class Solution {
    /*
    public boolean recursion(int[] nums,int i,int rSum,Boolean[][] dp){
        if(rSum == 0) return true;
        if( i >= nums.length || rSum < 0) return false;
        if(dp[i][rSum]!=null) return dp[i][rSum];
        return dp[i][rSum] = recursion(nums,i+1,rSum-nums[i],dp) || recursion(nums,i+1,rSum,dp);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length][(sum/2)+1];

        return recursion(nums,0,sum/2,dp);
    }
    */

    /*
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0) return false;

        boolean[][] dp = new boolean[nums.length+1][(sum/2)+1];

        for(boolean[] dps : dp){
            Arrays.fill(dps,false);
        }

        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<dp.length;i++){
            for(int sums=1;sums<=(sum/2);sums++){
 
                 // skip 
                 dp[i][sums] = dp[i-1][sums];

                 // pick
                 if(sums>=nums[i-1]){
                    dp[i][sums]  = dp[i][sums] || dp[i-1][sums-nums[i-1]];
                 }

            }
        }

        return dp[nums.length][sum/2];
    }
    */

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0) return false;

        int target = sum / 2;
boolean[] dp = new boolean[target + 1];
dp[0] = true;

for(int i = 0; i < nums.length; i++){
    for(int s = target; s >= nums[i]; s--){
        dp[s] = dp[s] || dp[s - nums[i]];
    }
}

       return dp[target];
    }
    
    }


    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.canPartition(new int[]{1,5,11,5}));
    }
}
