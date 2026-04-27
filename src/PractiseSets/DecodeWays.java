package PractiseSets;
import java.util.Arrays;
public class DecodeWays {
    static class Solution{
        /*
        int ways = 0;
        public void decodeRecursion(String s,int idx){
            if(idx>=s.length()){
                 ways++;
                 return;
            } 

            // single digit
            int one = s.charAt(idx) - '0';

            if(one!=0){
                decodeRecursion(s,idx+1);
            }

            // two digits
            if( idx < s.length() - 1 ){

                int twoDigits = (s.charAt(idx) - '0')*10 + (s.charAt(idx+1) - '0');

                if( twoDigits >= 10 && twoDigits <= 26){
                    decodeRecursion(s,idx+2);
                }

            }
        }
        public int numDecodings(String s){
            decodeRecursion(s,0);
            return ways;
        }
        */

    private int recursiveHelper(String s, int index,int[] memo) {
        // Base case: If we've reached the end of the string, it's one valid way.
        if (index == s.length()) return 1;

        // Base case: If the current digit is '0', it cannot be decoded.
        if (s.charAt(index) == '0') return 0;

        if(memo[index] != -1) return memo[index];

        // Way 1: Decode a single digit
        int ways = recursiveHelper(s, index + 1,memo);

        // Way 2: Decode two digits if valid (10-26)
        if (index + 1 < s.length()) {
            int twoDigit = (s.charAt(index) - '0') * 10 + (s.charAt(index+1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += recursiveHelper(s, index + 2,memo);
            }
        }

        return memo[index] = ways;
    }

    private int bottomUp(String s) {

        int[] dp = new int[s.length()+1];

        // Base case: If we've reached the end of the string, it's one valid way.
        dp[s.length()] = 1;

        for(int i=s.length()-1;i>=0;i--){

            if (s.charAt(i) != '0'){
                dp[i] = dp[i+1];
            }else{
                dp[i] = 0;
            }
            
            if (i + 1 < s.length()) {
                int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i+2];
                }
            }

        }

        return dp[0];
    }

    // constant space

    private int bottomUpByConstantSpace(String s) {

    int n = s.length();

    int prev = 1;   // dp[i+1]
    int prev1 = 0;  // dp[i+2]
    int curr = 0;

    for (int i = n - 1; i >= 0; i--) {

        if (s.charAt(i) != '0') {
            curr = prev;   // single digit
        } else {
            curr = 0;
        }

        if (i + 1 < n) {
            int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev1;  // two digit
            }
        }

        // shift values
        prev1 = prev;
        prev = curr;
    }

    return prev;
}


private int bottomUpByConstantSpace100(String s) {

    int n = s.length();

    int next1 = 1; // dp[n]
    int next2 = 0; // dp[n+1] (dummy, will align after first iteration)

    for (int i = n - 1; i >= 0; i--) {

        int curr = 0;

        // single digit
        if (s.charAt(i) != '0') {
            curr += next1;
        }

        // two digits
        if (i + 1 < n) {
            int val = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (val >= 10 && val <= 26) {
                curr += next2;
            }
        }

        // shift
        next2 = next1;
        next1 = curr;
    }

    return next1;
}


    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return recursiveHelper(s, 0,memo);
    }


    }   

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("2101"));
    }
}
