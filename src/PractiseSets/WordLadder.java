package PractiseSets;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;


public class WordLadder {
    static public class Solution{
        public void buildPatternMap(String s,Map<String,List<String>> map){
             for(int i=0;i<s.length();i++){
                 String pattern = s.substring(0,i) + "*" + s.substring(i+1);
                 map.computeIfAbsent(pattern , k->new ArrayList<String>()).add(s);
             }
        }
        public int ladderLength(String beginWord, String endWord, List<String> wordList){

            boolean hasEndWord = false;
            int level = 0;
            Map<String,List<String>> map = new HashMap<>();

            buildPatternMap(beginWord,map);
            for(String s : wordList){
                if( s. equals(endWord)) hasEndWord = true;
                buildPatternMap(s,map);
            }

            if(!hasEndWord) return 0;

            Queue<String> q = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();

            q.add(beginWord);
            visited.add(beginWord);

            while(!q.isEmpty()){

                int levels = q.size();

                for(int i=0;i<levels;i++){
                     
                    String s = q.poll();

                    if(s.equals(endWord)) return level+1;

                    for(int j=0;j<s.length();j++){

                        String pattern = s.substring(0,i) + "*" + s.substring(i+1);

                        for(String nei : map.get(pattern)){
                             if(!visited.contains(nei)) q.offer(nei);
                        }
                    }

                }

                level++;
            }
            return level;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(sol.ladderLength("hit","cog",list));
    }
}
