package Revision.Graphs;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

public class WordLadder {
    static class Solution {

    public void buildGraph(String s,Map<String,List<String>> graph){

        for(int i=0;i<s.length();i++){
            String key = s.substring(0,i) + "*" + s.substring(i+1,s.length());
            graph.computeIfAbsent(key,k->new ArrayList<>()).add(s);
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String,List<String>> graph = new HashMap<>();
        
        boolean hasEndWord = false;

        buildGraph(beginWord,graph);

        for(String str : wordList){
            if(str.equals(endWord)) hasEndWord = true;
            buildGraph(str,graph);
        }

        int transformationCount = 0;

        if(!hasEndWord) return transformationCount;

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty()){

            int levels = q.size();

            for(int i=0;i<levels;i++){

                String currWrd = q.poll();

                if(currWrd.equals(endWord)) return 1+transformationCount;

                for(int j=0;j<currWrd.length();j++){
                    String key = currWrd.substring(0,j) + "*" + currWrd.substring(j+1,currWrd.length());
 
                    if(graph.containsKey(key)){
                      for(String neighbor : graph.get(key)){
                         if(!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            q.add(neighbor);
                         }
                      }
                    }
                }

            }

            transformationCount++;
        }

        return 0;  // when endWord never reaches
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));
    }
}
