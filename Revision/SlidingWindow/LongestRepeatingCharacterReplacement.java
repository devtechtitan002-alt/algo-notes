package Revision.SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    static class Solution {
    public int characterReplacement(String s, int k) {

        // freq array for getting maxFreq within the current window
        int[] freq = new int[26];

        int left=0,maxLen=0,maxFreq=0;

        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);

            // current char freq
            freq[ch-'A']++;

            // maxFreq calculation 
            maxFreq = Math.max(maxFreq,freq[ch-'A']);

            while(( (right - left + 1) - maxFreq ) > k){
                char chLeft = s.charAt(left);
                freq[chLeft-'A']--;
                left++;
            }

            maxLen = Math.max( maxLen , right - left + 1 );
        }

        return maxLen;
    }
    }

    public static void main(String[] args){
         Solution sol = new Solution();
         System.out.println(sol.characterReplacement("ABAB",2));
    }
}
