package Revision.DP;
import java.util.Arrays;

public class ClaimbingStairs {

    // recursive apparoach
    /*
    public int recurse(int n){
        if(n==1 || n==2) return n;
        return recurse(n-1)+recurse(n-2);
    }
    public int climbStairs(int n) {
        return recurse(n);
    }
        */


    // Memo
 
    /* 
    public int recurse(int n,int[] memo){

        if(n==1 || n==2) return n;

        if(memo[n] != -1) return memo[n];

        return memo[n] = recurse(n-1,memo)+recurse(n-2,memo);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return recurse(n,memo);
    }
    */


    // Bottom Up
    /*
    public int climbStairs(int n) {

        if(n<=2) return n;

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
           dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    */

    // Bottom Up with 2 var

    public int climbStairs(int n) {

        if(n<=2) return n;

        int prev2 = 1;
        int prev1 = 2;
        int ans = 0;

        for(int i=3;i<=n;i++){
           ans = prev1 + prev2;
           prev2 = prev1;
           prev1 = ans;
        }

        return ans;
    }

}
