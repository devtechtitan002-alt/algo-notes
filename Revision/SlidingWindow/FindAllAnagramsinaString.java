package Revision.SlidingWindow;

import java.util.List;
import java.util.ArrayList;

public class FindAllAnagramsinaString {
    static class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        if(s.length() < p.length()) return new ArrayList<>();

        // Result List
        List<Integer> res = new ArrayList<>();

        // As s and p consists of lower englis letters only so we use arr instead of map for frequency tracking
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        // build p's freq arr as it decides whether current matches p 
        for(char ch : p.toCharArray()){
            pFreq[ch-'a']++;
        }

        // this matches determines all characters in p matches against current window 
        int matches = 0;

        // get matches initial value ( excpet charcaters in p's count )
        for(int i=0;i<26;i++){
            if(pFreq[i] == 0) matches++;
        }

        // iterate thorugh s characters to get window's characters freq matches with p's charcaters freq
        int left = 0;
        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);

            sFreq[ch-'a']++;  // count freq of s's chars

            if(pFreq[ch-'a'] == sFreq[ch-'a']) matches++;    // As p and s has same count then one matches char found so matches increase

            if(pFreq[ch-'a'] == sFreq[ch-'a']-1) matches--;  // if uncontributed char ( ch which is not in p ) we should decrement matches becuase it should remove from valid match

            if(right >= p.length()-1){

                if(matches == 26) res.add(left);   // As left was the start of window

                char chLeft = s.charAt(left);

                if(pFreq[chLeft-'a'] == sFreq[chLeft-'a']) matches--;  // if the left char ( which is going to remove from window ) if it contributes to valid window result need to decrement matches

                if(pFreq[chLeft-'a'] == sFreq[chLeft-'a']-1) matches++;  // As the uncontributed char we decrement matches before ( as it not contributing ) now its leave window so we have to increment matches
            
                sFreq[chLeft-'a']--;

                left++;
            }
        }

        return res;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findAnagrams("abab","ab"));
    }
}
