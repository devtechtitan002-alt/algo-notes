package Subsequence;
import java.util.Arrays;
public class LongestCommonSubsequence {
    static class Solution {
        /* 
    public int commonSubSeqLength(String s1,int i1,String s2,int i2){
        if( i1<0 || i2<0) return 0;

        if(s1.charAt(i1) == s2.charAt(i2)) return 1 + commonSubSeqLength(s1,i1-1,s2,i2-1);
        else return Math.max(commonSubSeqLength(s1,i1-1,s2,i2),commonSubSeqLength(s1,i1,s2,i2-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return commonSubSeqLength(text1,text1.length()-1,text2,text2.length()-1);
    }
    */
    
    public int commonSubSeqLength(String s1,int i1,String s2,int i2,int[][] dp){
    if(i1 < 0 || i2 < 0) return 0;

    if(dp[i1][i2] != -1) return dp[i1][i2];

    if(s1.charAt(i1) == s2.charAt(i2)) {
        return dp[i1][i2] = 1 + commonSubSeqLength(s1,i1-1,s2,i2-1,dp);
    } else {
        return dp[i1][i2] = Math.max(
            commonSubSeqLength(s1,i1-1,s2,i2,dp),
            commonSubSeqLength(s1,i1,s2,i2-1,dp)
        );
    }
}

public int longestCommonSubsequence(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();

    int[][] dp = new int[n][m];
    for(int i=0;i<n;i++){
        Arrays.fill(dp[i], -1);
    }

    int len = commonSubSeqLength(text1,n-1,text2,m-1,dp);

    for(int[] dps : dp){
        System.out.println(Arrays.toString(dps));
    }

    return len;
    }

    /*
    
    import java.util.*;

public class Solution {

    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Step 1: Build LCS DP table
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Step 2: Traverse DP to build SCS
        StringBuilder res = new StringBuilder();
        int i = n, j = m;

        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                res.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                res.append(s1.charAt(i-1));
                i--;
            }
            else{
                res.append(s2.charAt(j-1));
                j--;
            }
        }

        // Step 3: Add remaining characters
        while(i > 0){
            res.append(s1.charAt(i-1));
            i--;
        }

        while(j > 0){
            res.append(s2.charAt(j-1));
            j--;
        }

        // Step 4: Reverse result
        return res.reverse().toString();
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(sol.shortestCommonSupersequence(s1, s2)); // cabac
    }
}
    
*/
     
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestCommonSubsequence("abac","cab"));
    }
}
