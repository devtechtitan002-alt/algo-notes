package Revision.ArraysHashing;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class GroupAnagrams {
    static class Solution{
        public String getFreqKey(String s){

            // frequency array
            int[] freqArr = new int[26];
            for(char ch : s.toCharArray()){
                freqArr[ch-'a']++;
            }

            StringBuilder sb = new StringBuilder();

            // building key  // just sorting also helps ( to generate key )
            for(int freq : freqArr){
                sb.append(freq).append("#");
            }

            return sb.toString();
        }
        public  List<List<String>> groupAnagrams(String[] strs){
            Map<String,List<String>> map = new HashMap<>();
            for(String s : strs){
                String freqKey = getFreqKey(s);
                map.computeIfAbsent(freqKey, key -> new ArrayList<String>()).add(s);
            }

            // Map's values
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List list : sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})){
            System.out.println(list);
        }
    }
}
