package DP;

public class PalindromicSubstrings {
    static class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0 ) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int countPalindromes = 0;

        // 1 length
        for(int i=0;i<dp.length;i++){
            dp[i][i] = true;
            countPalindromes++;
        }

        // >=2 length

        for(int len=2;len<=s.length();len++){
           for(int i=0;i<=s.length()-len;i++){
              int j = i+len-1;

              if(s.charAt(i)==s.charAt(j)){
                  if(len==2 || dp[i+1][j-1]){
                     dp[i][j]=true;
                     countPalindromes++;
                  }
              }
           }
        }
        return countPalindromes;
    }
    /*
    public int countSubstrings(String s) {
    int n = s.length();
    int count = 0;

    for (int center = 0; center < 2*n - 1; center++) {
        int left = center / 2;
        int right = left + center % 2;

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    return count;
}
     */
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.countSubstrings("babab"));
    }
}
