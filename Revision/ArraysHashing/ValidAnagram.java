package Revision.ArraysHashing;

public class ValidAnagram {
    static class Solution{
        public boolean isValidAnagram(String s,String t){
            int[] freq = new int[26];

            if(s.length() != t.length()) return false;

            for(int i=0;i<s.length();i++){
                ++freq[s.charAt(i)-'a'];
                --freq[t.charAt(i)-'a'];
            }

            // wlak through freq arr should all freq nullifies == 0
            for(int num : freq){
                if(num != 0) return false;
            }

            return true;
        }
    }

    public static void main(String[] arg){
        Solution sol = new Solution();
        System.out.println(sol.isValidAnagram("anagram","nagaram"));
    }
}
