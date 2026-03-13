import java.util.Arrays;
public class PermutationinString {
    static class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left=0;
        int[] s1FreqArr = new int[26];
        int[] windowFreqArr = new int[26];
        for(int i=0;i<s1.length();i++){
            s1FreqArr[s1.charAt(i)-'a']++;
        }
        for(int right=0;right<s2.length();right++){
            windowFreqArr[s2.charAt(right)-'a']++;
            if(right>=s1.length()-1){
              if(Arrays.equals(s1FreqArr,windowFreqArr)) return true;
              windowFreqArr[s2.charAt(left++)-'a']--;
            }
        }
        return false;
        /*
        int left = 0, matches = 0;
int[] s1Freq = new int[26];
int[] winFreq = new int[26];

for(char c : s1.toCharArray()) s1Freq[c-'a']++;

// Count initial matches
for(int i = 0; i < 26; i++)
    if(s1Freq[i] == winFreq[i]) matches++;  // how many distinct characters are there in s1 = 26-matches // except characters in s1 all are set to 0 so 

for(int right = 0; right < s2.length(); right++){
    char rc = s2.charAt(right);
    winFreq[rc-'a']++;
    if(winFreq[rc-'a'] == s1Freq[rc-'a']) matches++;
    else if(winFreq[rc-'a'] == s1Freq[rc-'a']+1) matches--;

    if(right >= s1.length()-1){
        if(matches == 26) return true;
        char lc = s2.charAt(left++);
        if(winFreq[lc-'a'] == s1Freq[lc-'a']) matches--;
        else if(winFreq[lc-'a'] == s1Freq[lc-'a']+1) matches++;
        winFreq[lc-'a']--;
    }
}
return false;
         */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.checkInclusion("ab", "eidbaoo"));
        System.out.println(sol.checkInclusion("ab", "eidboaoo"));
        System.out.println(sol.checkInclusion("adc", "dcda"));
        System.out.println(sol.checkInclusion("hello", "ooolleoooleh"));

    }
}
}
