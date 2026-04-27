package PractiseSets;
import java.util.Set;
import java.util.HashSet;
public class LengthOfLongestSubString {
    static class Solution{
        public int lengthOfLongestSubstring(String s){
            int left=0,maxLen=0;
            Set<Character> set = new HashSet<>();
            for(int right=0;right<s.length();right++){

                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(s.charAt(right));
                maxLen = Math.max(maxLen , ((right-left)+1));

            }
            return maxLen;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("pwwke"));
    }
}
