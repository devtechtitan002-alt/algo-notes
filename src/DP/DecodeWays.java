package DP;

public class DecodeWays {
    static class Solution {
    public int numDecodings(String s) {
        if( s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
           char ch = s.charAt(i);
           int ways = 0;
           if(ch == '0'){
               ways = Integer.valueOf(s.substring(i-1,i+1)) <= 26 ? 1 : -1;
           }else{
               ways = Integer.valueOf(s.substring(i-1,i+1)) <= 26 ? 1 : -0;
           }
           dp[i] = dp[i-1]+ways;
        }
        return dp[dp.length-1];
    }

    /*
    \class Solution {
    public int numDecodings(String s) {
    int n = s.length();
    if (n == 0 || s.charAt(0) == '0') return 0;

    int[] dp = new int[n];
    dp[0] = 1; // first char is valid (not '0')

    for (int i = 1; i < n; i++) {

        // 1. Single digit
        if (s.charAt(i) != '0') {
            dp[i] += dp[i - 1];
        }

        // 2. Double digit
        int twoDigit = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
        if (twoDigit >= 10 && twoDigit <= 26) {
            if (i == 1) {
                dp[i] += 1;   // dp[-1] = 1 case
            } else {
                dp[i] += dp[i - 2];
            }
        }
    }

    return dp[n - 1];
}
}
 */
}
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("11106"));
    }
}
