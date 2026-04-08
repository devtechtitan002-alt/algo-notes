package DP;

public class MinCostClimbingStairs {
    static class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) return 0;
        int[] dp = new int[cost.length];
        if(cost.length == 1) return cost[0];
        if(cost.length == 2) return Math.min(cost[0],cost[1]);
        dp[0] = cost[0];
        dp[1] = cost[1]+cost[0];
        for(int i=2;i<cost.length;i++){
            cost[i] += Math.min(cost[i-2],cost[i-1]);
            dp[i] = Math.min(cost[i],cost[i-1]);
        }
        return dp[dp.length-1];
        /*
        public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    
    if (n == 1) return cost[0];

    int[] dp = new int[n];
    dp[0] = cost[0];
    dp[1] = cost[1];

    for (int i = 2; i < n; i++) {
        dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    }

    return Math.min(dp[n-1], dp[n-2]);
}
     */
    }
}
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.minCostClimbingStairs(new int[]{10,15,20}));
    }
}
