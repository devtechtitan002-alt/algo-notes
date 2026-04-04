package Subsequence;
import java.util.Arrays;
public class DistinctSubsequences {
    static class Solution {
    public int buildSubsequences(String s,int sIdx,String t,int tIdx,int[][] dp){
        if(tIdx < 0 ) return 1;
        if(sIdx < 0 ) return 0;

        if(dp[sIdx][tIdx] != -1) return dp[sIdx][tIdx];

        if( s.charAt(sIdx) == t.charAt(tIdx) ){
            int pick = buildSubsequences(s,sIdx-1,t,tIdx-1,dp);
            int skip = buildSubsequences(s,sIdx-1,t,tIdx,dp);
            return dp[sIdx][tIdx] = pick+skip;
        }
        return dp[sIdx][tIdx] = buildSubsequences(s,sIdx-1,t,tIdx,dp);
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] subDps : dp){
            Arrays.fill(subDps,-1);
        }
        return buildSubsequences(s,s.length()-1,t,t.length()-1,dp);
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numDistinct("babagx","bag"));
    }
}
