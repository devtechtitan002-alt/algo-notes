package Revision.DP;
import java.util.Arrays;

public class CoinChange {
    static class Solution {

      /*
      public int recurse(int idx, int target, int[] coins, int[] counter, int[][] memo) {

        if (target == 0) {
            counter[1] = Math.min(counter[0], counter[1]);
            return counter[1];
        }

        if (target < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = idx; i < coins.length; i++) {
            counter[0] += 1;
            int value = recurse(i, target - coins[i], coins, counter, memo);
            if (value != -1) {
                min = Math.min(min, value);
            }
            counter[0] -= 1;
        }

        return min == Integer.MAX_VALUE ? counter[1] : min;
    }

    public int coinChange(int[] coins, int amount) {
        int[] totalVsMin = new int[2];
        totalVsMin[1] = Integer.MAX_VALUE;
        int[][] memo = new int[coins.length][amount + 1];
        int ans = recurse(0, amount, coins, totalVsMin, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    */

    public int recurse(int idx, int count, int target, int[] coins, int[][] memo) {

        if (target == 0) {
            return count;
        }

        if (target < 0) {
            return -1;
        }

        if(memo[idx][target]!=-1) return memo[count][target];

        int min = Integer.MAX_VALUE;
        for (int i = idx; i < coins.length; i++) {
            int value = recurse(i,count+1,target - coins[i], coins, memo);
            if (value != -1) {
                min = Math.min(min, value);
            }
        }

        return memo[idx][target] = min == Integer.MAX_VALUE ? -1 : min;
    }

    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length + 1][amount + 1];
        for(int[] dp : memo){
           Arrays.fill(dp,-1);
        }
        int ans = recurse(0, 0,amount, coins, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1,2,5},10));
    }


    /*
     public static int recurse(int idx, int target, int[] coins, int[] counter, int[][] memo) {

        if (target == 0) {
            counter[1] = Math.min(counter[0], counter[1]);
            return counter[1];
        }

        if (target < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = idx; i < coins.length; i++) {
            counter[0] += 1;
            int value = recurse(i, target - coins[i], coins, counter, memo);
            if (value != -1) {
                min = Math.min(min, value);
            }
            counter[0] -= 1;
        }

        return min == Integer.MAX_VALUE ? counter[1] : min;
    }

    public static int coinChange(int[] coins, int amount) {
        int[] totalVsMin = new int[2];
        totalVsMin[1] = Integer.MAX_VALUE;
        int[][] memo = new int[coins.length][amount + 1];
        int ans = recurse(0, amount, coins, totalVsMin, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
         */

    /*
    public int recurse(int idx, int target, int[] coins, int[] counter, int[][] memo) {

        if (target == 0) {
            counter[1] = Math.min(counter[0], counter[1]);
            return  counter[1];
        }

        if (target < 0) {
            return  -1;
        }

        if( memo[idx][target]  != -1) return  memo[idx][target];

        int min = Integer.MAX_VALUE;
        for (int i = idx; i < coins.length; i++) {
            counter[0] += 1;
            int value = recurse(i, target - coins[i], coins, counter, memo);
            if (value != -1) {
                min = Math.min(min, value);
            }
            counter[0] -= 1;
        }

        return memo[idx][target] = min == Integer.MAX_VALUE ? counter[1] : min;
    }

    public int coinChange(int[] coins, int amount) {
        int[] totalVsMin = new int[2];
        totalVsMin[1] = Integer.MAX_VALUE;
        int[][] memo = new int[coins.length][amount + 1];
        for(int[] dps : memo){
            Arrays.fill(dps,-1);
        }
        int ans = recurse(0, amount, coins, totalVsMin, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    } */
}
