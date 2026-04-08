package DP;

public class BurstBallons {
    static class Solution {
    int solve(int[] nums,int i, int j){
    if(i > j) return 0;

    int max = -1;

    for(int k = i; k < j; k++){
        int cost = 
        solve(nums,i, k-1) +
        + nums[i-1] * nums[k] * nums[j+1]
        + solve(nums,k+1, j);
        max = Math.max(max, cost);
    }

    return max;
    }
    public int maxCoins(int[] nums) {  
       int[] ballons = new int[nums.length+2];
       ballons[0] = ballons[nums.length+1] = 1;
       return solve(ballons,0,ballons.length);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxCoins(new int[]{3,1,5,8}));
    }
}
