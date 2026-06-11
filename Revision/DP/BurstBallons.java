package Revision.DP;
import java.util.Arrays;

public class BurstBallons {
    static class Solution {

    // recursive approach

    public int burstBallons(int[] nums,int s,int e){
        if(s > e) return 0;

        int coin = 0;

        for(int i=s;i<=e;i++){
            coin = Math.max(coin,(nums[s-1]*nums[i]*nums[e+1] + burstBallons(nums,s,i-1) + burstBallons(nums,i+1,e)));
        }

        return coin;
    }

    public int maxCoins(int[] nums) {
        int[] border = new int[nums.length+2];
        
        for(int i=0;i<border.length;i++){
            if(i==0 || i==nums.length+1) border[i] = 1;
            else border[i] = nums[i-1];
        }

        return burstBallons(border,1,nums.length);
    }

    // DP Memoization

    public int burstBallonsDP(int[] nums,int s,int e,int[][] memo){
        if(s > e) return 0;

        if(memo[s][e] != -1) return memo[s][e];

        int coin = 0;

        for(int i=s;i<=e;i++){
            coin = Math.max(coin,(nums[s-1]*nums[i]*nums[e+1] + burstBallonsDP(nums,s,i-1,memo) + burstBallonsDP(nums,i+1,e,memo)));
        }

        return memo[s][e] = coin;
    }

    public int maxCoinsDP(int[] nums) {
        int[] border = new int[nums.length+2];
        
        for(int i=0;i<border.length;i++){
            if(i==0 || i==nums.length+1) border[i] = 1;
            else border[i] = nums[i-1];
        }

        int[][] memo = new int[nums.length+1][nums.length+1];

        for(int[] dps : memo){
            Arrays.fill(dps,-1);
        }

        return burstBallonsDP(border,1,nums.length,memo);
    }


    // DP Bottom Up

    public int burstBallonsDPBU(int[] nums,int s,int e,int[][] memo){
        if(s > e) return 0;

        if(memo[s][e] != -1) return memo[s][e];

        int coin = 0;

        for(int k=s;k<=e;k++){
            coin = Math.max(coin,(nums[s-1]*nums[k]*nums[e+1] + burstBallonsDPBU(nums,s,k-1,memo) + burstBallonsDPBU(nums,k+1,e,memo)));
        }

        return memo[s][e] = coin;
    }

    public int maxCoinsDPBU(int[] nums) {
        int[] border = new int[nums.length+2];
        
        for(int i=0;i<border.length;i++){
            if(i==0 || i==nums.length+1) border[i] = 1;
            else border[i] = nums[i-1];
        }

        int[][] memo = new int[nums.length+1][nums.length+1];

        for(int[] dps : memo){
            Arrays.fill(dps,-1);
        }

        int[][] dp = new int[nums.length+2][nums.length+2];

        int s=1,n=dp.length;

        for(int i=n;i>=1;i--){

    for(int j=i;j<=n;j++){

        for(int k=i;k<=j;k++){

            dp[i][j] =
                Math.max(
                    dp[i][j],

                    border[i-1]*border[k]*border[j+1]
                    +
                    dp[i][k-1]
                    +
                    dp[k+1][j]
                );
        }
    }
}

        return dp[1][n];

    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxCoins(new int[]{1,5}));
    }
}
