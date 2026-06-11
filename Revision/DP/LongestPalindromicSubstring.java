package Revision.DP;

public class LongestPalindromicSubstring {
    static class Solution{
        public String longestPalindrome(String s) {

            int start=0,maxLen=0;

            for(int i=0;i<s.length();i++){

                int l=i,r=i;

                while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }

                int currLen = (r-l)-1;
                if( currLen > maxLen ){
                    start = l+1;
                    maxLen = currLen;
                }

                l=i;
                r=i+1;

                if(r < s.length()){

                    while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                        l--;
                        r++;
                    }

                    currLen = (r-l)-1;
                    if( currLen > maxLen ){
                    start = l+1;
                    maxLen = currLen;
                }

                }

               
            }

            return s.substring(start,start+maxLen);
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("abcba"));
    }
}
