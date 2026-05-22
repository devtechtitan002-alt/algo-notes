package Revision.SlidingWindow;

import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {
    static class Solution {
    public String minWindow(String s, String t) {

        String resStr = "";

        if(s.length() < t.length()) return resStr;

        // for freq track we need 2 maps
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        // building frequency map for t
        for(char ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }

        // iterate thoughout s and get all possible substring contains all characters in t
        int left=0,minLen=Integer.MAX_VALUE,lengthMatcher = 0;

        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);

            // sMap build simultaneously
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);

            if(tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch)) lengthMatcher++;
            

            // shrink window when lengthMatcher matched against t's length
            while(lengthMatcher == t.length()){

                int windowLen = right-left+1;
                if(windowLen < minLen){
                   resStr = s.substring(left,right+1);
                   minLen = windowLen;
                }

                // System.out.println(resStr);

                char chLeft = s.charAt(left);

                if(tMap.containsKey(chLeft) && sMap.get(chLeft) <= tMap.get(chLeft)) lengthMatcher--;

                sMap.put(chLeft,sMap.get(chLeft)-1);

                left++;

            }
        }

        return resStr;
    }
    }

    public static void main(String[] args){
         Solution sol = new Solution();
         System.out.println(sol.minWindow("ADOBECODEBANC","ABC"));
    }
}
