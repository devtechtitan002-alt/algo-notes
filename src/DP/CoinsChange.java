package DP;

public class CoinsChange {
    static class Solution {
    public int recursion(int[] coins,int idx,int amt){
        if(idx<0 || idx>= coins.length) return Integer.MAX_VALUE;
        int fewer = Integer.MAX_VALUE;
        if( amt >= coins[idx] ){
            fewer = amt/coins[idx];
            amt = amt - fewer*coins[idx];
        }
        int left = recursion(coins,idx-1,amt);
        int right = recursion(coins,idx+1,amt);

        if(left!=Integer.MAX_VALUE) fewer += left;
        if(right!=Integer.MAX_VALUE) fewer += right;

        return Math.min(fewer,Math.min(left,right));
    }
    public int coinChange(int[] coins, int amount) {
        int fewest = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            fewest = Math.min(fewest,recursion(coins,i,amount));
        }
        return fewest == Integer.MAX_VALUE ? -1 : fewest;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1,2,5},11));
    }
}
