package DP;

public class LongestPalindromicSubstring {
    static class Solution {
        /* 
    public boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String res = "";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                System.out.println(s.substring(i,j));
                if(isPalindrome(s.substring(i,j))){
                    res = res.length() > s.substring(i,j).length() ? res : s.substring(i,j);
                }
            }
        }
        return res;
    }
        */
     public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String res = "";
        String[] dp = new String[s.length()];
        dp[0] = s.charAt(0)+"";
        dp[1] = s.charAt(1)+"";
        for(int i=2;i<s.length();i++){
            if( s.charAt(i) == dp[i-2].charAt(0) ){
                res = dp[i-2] + s.substring(i-1,i+1);
                dp[i] = res;
            }else{
                if( s.charAt(i) == dp[i-1].charAt(0) ){
                res = dp[i-1] + s.charAt(i);
                dp[i] = res;
            }
            }
        }
        return res;
        /*
        public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    int start = 0, maxLen = 1;

    // length 1
    for (int i = 0; i < n; i++) {
        dp[i][i] = true;
    }

    // length 2+
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;

            if (s.charAt(i) == s.charAt(j)) {
                if (len == 2 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
    }

    return s.substring(start, start + maxLen);
}
     */
    }

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("cbbd"));
    }

}
