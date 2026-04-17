import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
public class FindAllAnagramsinaString {
    static class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int count=0;
        int left=0;
        for(char ch : p.toCharArray()){
            pMap.put(ch,pMap.getOrDefault(ch,0)+1);
        }
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            if(pMap.containsKey(ch) && sMap.get(ch) <= pMap.get(ch)){
                count++;
            }
            if(right>=p.length()-1){
                if(count==p.length()){ list.add(left); }
                char charLeft = s.charAt(left);
                if(pMap.containsKey(charLeft) && sMap.get(charLeft) <= pMap.get(charLeft)){
                    count--;
                }
                sMap.put(charLeft,sMap.get(charLeft)-1);
                left++;
            }
        }
        return list;
    }

    /*
    import java.util.*;

public class FindAllAnagramsinaString {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            
            if (s.length() < p.length()) return result;

            int[] freq = new int[26];

            // Build frequency of p
            for (char c : p.toCharArray()) {
                freq[c - 'a']++;
            }

            int left = 0, right = 0, count = p.length();

            while (right < s.length()) {
                char ch = s.charAt(right);

                // If char is needed, reduce count
                if (freq[ch - 'a'] > 0) {
                    count--;
                }
                freq[ch - 'a']--;

                right++;

                // When window size == p.length()
                if (right - left == p.length()) {

                    if (count == 0) {
                        result.add(left);
                    }

                    char leftChar = s.charAt(left);

                    // Restore frequency
                    if (freq[leftChar - 'a'] >= 0) {
                        count++;
                    }
                    freq[leftChar - 'a']++;

                    left++;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findAnagrams("cbaebabacd","abc")); // [0,6]
    }
}
     */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findAnagrams("cbaebabacd","abc"));
        System.out.println(sol.findAnagrams("cbaebabacd","abc"));
    }
}
