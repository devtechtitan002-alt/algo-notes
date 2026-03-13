import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
public class LongestSubstringWithoutRepeatingCharacters {
    static class Solution{
        public int lengthOfLongestSubstring(String s) {
           int maxLen=0,left=0;
           //HashSet<Character> set = new HashSet<>();
           Map<Character,Integer> freqMap = new HashMap<>();
           //int[] freqArr = new int[128];
           for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            while(  freqMap.containsKey(ch) /*freqArr[(int)ch]>0 */   /*set.contains(s.charAt(right))*/ ){
                left=Math.max(left,freqMap.get(ch)+1);//freqArr[(int)s.charAt(left)]--;//set.remove(s.charAt(left++));
                //left++;
            }
            freqMap.put(ch,right);//freqArr[(int)ch]++;//set.add(ch);
            maxLen = Math.max(maxLen,(right-left)+1);
           }
           return maxLen;
        }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));

    }
}
