package Revision.DP;
import java.util.Arrays;

public class DecodeWays {
    static class Solution{

        public int recurse(int idx,String s,int[] dp){
            if(idx >= s.length()) return 1;

            if(dp[idx] != -1) return dp[idx];

            int oneDigit=0,twoDigit=0;
                
            // single digit
            if(Integer.valueOf(s.charAt(idx)-'0') != 0){
                oneDigit = recurse(idx+1,s,dp);
            }

            // double digit
            if(idx<s.length()-1 && Integer.valueOf(s.substring(idx,idx+2)) >= 10 && Integer.valueOf(s.substring(idx,idx+2)) <= 26){
                twoDigit = recurse(idx+2,s,dp);
            } 

            return dp[idx] = oneDigit+twoDigit;
        }

        public int numDecodings(String s) {
           int[] dp = new int[s.length()+1];
           Arrays.fill(dp,-1);
           return recurse(0,s,dp);
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("11106"));
    }

}
