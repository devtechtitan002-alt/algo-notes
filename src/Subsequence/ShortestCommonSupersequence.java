package Subsequence;
import java.util.Arrays;
public class ShortestCommonSupersequence{
    static class Solution {
    public String solve(String s,int sIdx,String t,int tIdx,String[][] dp){
       if(sIdx < 0 ) return t.substring(0,tIdx+1);
       if(tIdx < 0 ) return s.substring(0,sIdx+1);

       if(!dp[sIdx][tIdx].equals(":")) return dp[sIdx][tIdx];

       if(s.charAt(sIdx) == t.charAt(tIdx)){
          return dp[sIdx][tIdx] = solve(s,sIdx-1,t,tIdx-1,dp)+""+s.charAt(sIdx);
       }

       String pickT =  solve(s,sIdx,t,tIdx-1,dp)+""+t.charAt(tIdx);
       String pickS =  solve(s,sIdx-1,t,tIdx,dp)+""+s.charAt(sIdx);

       return dp[sIdx][tIdx] = pickS.length() > pickT.length() ? pickT : pickS;
    } 
    public String shortestCommonSupersequence(String str1, String str2) {
        String[][] dp = new String[str1.length()][str2.length()];
        for(String[] dps : dp){
            Arrays.fill(dps,":");
        }
        String res = solve(str1,str1.length()-1,str2,str2.length()-1,dp);

        for(String[] dps : dp){
        System.out.println(Arrays.toString(dps));
        }

        return res;
    }
}
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.shortestCommonSupersequence("yabac","crrabxzs"));clear
        
    }
}
