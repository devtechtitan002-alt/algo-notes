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
            int level = 1;
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

                    if(s.equals(endWord)) return level;

                    for(int j=0;j<s.length();j++){

                        String pattern = s.substring(0,j) + "*" + s.substring(j+1);

                        for(String nei : map.getOrDefault(pattern, new ArrayList<>())){
                             if(!visited.contains(nei)) {
                                q.offer(nei);
                                visited.add(nei);
                             }
                        }

                        if(map.containsKey(pattern)) map.get(pattern).clear();
                    }

                }

                level++;
            }
            return 0;
        }

        // bidirectional bfs approach

        public int ladderLengthByBidirectionalBFS(String beginWord, String endWord, List<String> wordList){

            if(!wordList.contains(endWord)) return 0;

            int level = 1;
            Map<String,List<String>> map = new HashMap<>();

            buildPatternMap(beginWord,map);
            for(String s : wordList){
                buildPatternMap(s,map);
            }

            Set<String> beginSet = new HashSet<>();
            beginSet.add(beginWord);

            Set<String> endSet = new HashSet<>();
            endSet.add(endWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);


            while(!beginSet.isEmpty() && !endSet.isEmpty()){

                //expand small 
                if(beginSet.size() > endSet.size()){
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                Set<String> next = new HashSet<>();

                for(String s : beginSet){
                     

                    for(int j=0;j<s.length();j++){

                        String pattern = s.substring(0,j) + "*" + s.substring(j+1);

                        for(String nei : map.getOrDefault(pattern, new ArrayList<>())){
                             if(endSet.contains(nei)) {
                                return level+1;
                             }else if(!visited.contains(nei)){
                                next.add(nei);
                                visited.add(nei);
                             }
                        }

                        if(map.containsKey(pattern)) map.get(pattern).clear();
                        
                    }

                }

                beginSet = next;

                level++;
            }
            return 0;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(sol.ladderLength("hit","cog",list));
    }
}
