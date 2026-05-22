package Revision.SlidingWindow;

public class PermutationinString {
    static class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // as problem ensures s1 and s2 contains only lower case english letters so we can go with freqArr
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // building s1Freq array as it decides whether permutations exists or not
        for(char ch : s1.toCharArray()){
            s1Freq[ch-'a']++;
        }

        // iterate s2 for checking permutation existance
        int left=0,required=s1.length();

        for(int right=0;right<s2.length();right++){

           int idx = s2.charAt(right)-'a';

           s2Freq[idx]++;
 
           if(s1Freq[idx] >= s2Freq[idx]) required--;

           if(right >= s1.length()-1){
              
               if(required == 0) return true;

               int idxLeft = s2.charAt(left)-'a';

               if(s1Freq[idxLeft] >= s2Freq[idxLeft]) required++;

               s2Freq[idxLeft]--;

               left++;

           }

        }
        return false;
    }
    }

    public static void main(String[] args){
         Solution sol = new Solution();
         System.out.println(sol.checkInclusion("ab","eidbaooo"));
    }
}
