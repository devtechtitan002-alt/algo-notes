package DP;

public class HouseRobber {
    static class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 0 ) return 0;
        if(n == 1 ) return nums[1];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return Math.max(dp[n-2],dp[n-1]);
    }
}
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{2,1,1,2}));
    }
}
