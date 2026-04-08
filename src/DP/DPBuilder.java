package DP;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class DPBuilder {

    // store subsets
    public void getSubsets(int i,int[] nums,int currSum,int target,List<Integer> curr,List<List<Integer>> res){
        if(i==nums.length){
            if(currSum==target) res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        getSubsets(i+1,nums,currSum+nums[i],target,curr,res);
        curr.remove(curr.size()-1);
        getSubsets(i+1,nums,currSum,target,curr,res);
    }
    public void subsetSumEqualsTarget(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        getSubsets(0,new int[]{1,2,3},0,3,curr,res);
    }

    // print ways
    public int getSubsets(int i,int[] nums,int currSum,int target,int[][] dp){
        if(i==nums.length){
            if(currSum==target) return 1;
            return 0;
        }
        if(currSum > target) return 0;
        if(dp[i][currSum]!=-1) return dp[i][currSum];
        return dp[i][currSum] = getSubsets(i+1,nums,currSum+nums[i],target,dp)+getSubsets(i+1,nums,currSum,target,dp);
    }
    public void subsetSumEqualsTargetWays(int[] nums){
        int target = 3;
        int[][] dp = new int[nums.length][target+1];
        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }
        int ways = getSubsets(0,nums,0,target,dp);
    }

    public static class SubsetSumCount {

    public static int countSubsets(int[] nums, int target) {
        int n = nums.length;

        // dp[i][sum] = ways to make 'sum' using first i numbers
        int[][] dp = new int[n + 1][target + 1];

        // Base case: sum = 0 → 1 way (take nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Build the table row by row
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {

                // 1️⃣ Skip current number
                dp[i][sum] = dp[i - 1][sum];

                // 2️⃣ Pick current number if sum >= nums[i-1]
                if (sum >= nums[i - 1]) {
                    dp[i][sum] += dp[i - 1][sum - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    /*
    int[] dp = new int[target + 1];
dp[0] = 1;  // base case: 0 sum → 1 way

for (int i = 0; i < nums.length; i++) {
    for (int sum = target; sum >= nums[i]; sum--) { // reverse to avoid overwrite
        dp[sum] += dp[sum - nums[i]];
    }
} */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 3;

        int ways = countSubsets(nums, target);
        System.out.println("Number of subsets = " + ways);
    }


    public int climbingStairs(int n){
        if(n == 1 || n==2) return n;
        return climbingStairs(n-1)+climbingStairs(n-2);
    }

    public int climbingStairsDP(int n){
        if(n == 1 || n==2) return n;
        return climbingStairs(n-1)+climbingStairs(n-2);
    }

    public int climbingStairs(int n,int[] dp){
        if(n==1 || n==2) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = climbingStairs(n-1)+climbingStairs(n-2);
    }

}
    public static void main(String[] args){
        int n = 4;
        int[] dp = new int[n];
        SubsetSumCount sol = new SubsetSumCount();
        sol.climbingStairs(n,dp);

        // bottom up
        int n = 4;
        int[] dps = new int[n];
        if(n==1||n==2) return n;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
    }
}
