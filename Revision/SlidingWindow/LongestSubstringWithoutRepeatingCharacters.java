package Revision.SlidingWindow;
import java.util.Set;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left=0,resLen=0;

        // for duplicates handling
        Set<Character> set = new HashSet<>();

        for(int right=0;right<s.length();right++){

            char ch = s.charAt(right);

            while(set.contains(ch)){
                char leftCh = s.charAt(left);
                set.remove(leftCh);
                left++;
            }

            set.add(ch);

            resLen = Math.max(resLen , (right-left)+1);
        }

        return resLen;
    }
    }

    public static void main(String[] args){
         Solution sol = new Solution();
         System.out.println(sol.lengthOfLongestSubstring("bbbb"));
    }
}
