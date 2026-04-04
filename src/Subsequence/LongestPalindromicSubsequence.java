package Subsequence;
import java.util.Arrays;
public class LongestPalindromicSubsequence {
    static class Solution {
        /*
    public boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public int recursion(String s,StringBuilder sb,int idx){
        if(idx==s.length()){
           if(sb.isEmpty()) return 0;
           return isPalindrome(sb.toString()) ? sb.toString().length() : 0;
        }
        int notpick = recursion(s,sb,idx+1);
        sb.append(s.charAt(idx));
        int pick = recursion(s,sb,idx+1);
        sb.deleteCharAt(sb.length()-1);
        return Math.max(notpick,pick);
    }
        */
    public int recursion(String s,int l,int r,int[][] dp){
        if(l==r) return 1;
        if( l > r ) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        if(s.charAt(l)==s.charAt(r)) return dp[l][r] = 2+recursion(s,l+1,r-1,dp);
        return dp[l][r] = Math.max(recursion(s,l+1,r,dp),recursion(s,l,r-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][];
        for(int[] dps : dp){
            Arrays.fill(dps,-1);
        }
        return recursion(s,0,s.length()-1,dp);
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindromeSubseq("bbbab"));
    }   
}
