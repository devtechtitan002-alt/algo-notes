package Revision.Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class AlienDictionary {
    static class Solution{
       
       public boolean isCycle(Map<Character,Set<Character>> map,char key,StringBuilder sb,Set<Character> visiting,Set<Character> visited){

         if(visiting.contains(key)){ 
            return true;
         }

         if(visited.contains(key)){
            return false;
         }

         visiting.add(key);

         for(char nei : map.get(key)){
            if(isCycle(map,nei,sb,visiting,visited)) return true;
         }

         visiting.remove(key);

         visited.add(key);
         sb.append(key);   // Post Order

         return false;

       }

       public String alienDic(String[] words){

           Map<Character,Set<Character>> graph = new HashMap<>();

           for(String word : words){
              for(char ch : word.toCharArray()){
                graph.putIfAbsent(ch,new HashSet<>());
              }
           } 

           for(int i=1;i<words.length;i++){
              
               String w1 = words[i-1];
               String w2 = words[i];

               if(w1.length() > w2.length() && w1.startsWith(w2)) return "";  // As invalid input given 

               int minLen = Math.min(w1.length(),w2.length());

               for(int j=0;j<minLen;j++){

                  char ch1 = w1.charAt(j);
                  char ch2 = w2.charAt(j);

                  if(ch1 != ch2){
                     graph.get(ch1).add(ch2);
                     break;
                  }
               }

           }

           StringBuilder order = new StringBuilder();

           Set<Character> visited = new HashSet<>();
           Set<Character> visiting = new HashSet<>();

           for(char key : graph.keySet()){
             if (!visited.contains(key)) {
               if(isCycle(graph,key,order,visiting,visited)) return "";
             }
           }

           return order.reverse().toString();

          
       }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.alienDic(new String[]{"wrt","wrf","er","ett","rftt"}));
    }

    /*
    // From Open AI

    import java.util.*;

public class AlienDictionary {

    static class Solution {

        private boolean dfs(char node,
                            Map<Character, Set<Character>> graph,
                            Set<Character> visiting,
                            Set<Character> visited,
                            StringBuilder order) {

            if (visiting.contains(node)) {
                return true; // cycle
            }

            if (visited.contains(node)) {
                return false;
            }

            visiting.add(node);

            for (char next : graph.get(node)) {
                if (dfs(next, graph, visiting, visited, order)) {
                    return true;
                }
            }

            visiting.remove(node);
            visited.add(node);

            order.append(node); // postorder

            return false;
        }

        public String alienOrder(String[] words) {

            Map<Character, Set<Character>> graph = new HashMap<>();

            // Add all characters
            for (String word : words) {
                for (char ch : word.toCharArray()) {
                    graph.putIfAbsent(ch, new HashSet<>());
                }
            }

            // Build graph
            for (int i = 1; i < words.length; i++) {

                String w1 = words[i - 1];
                String w2 = words[i];

                // Invalid prefix case
                if (w1.length() > w2.length() && w1.startsWith(w2)) {
                    return "";
                }

                int minLen = Math.min(w1.length(), w2.length());

                for (int j = 0; j < minLen; j++) {

                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);

                    if (c1 != c2) {
                        graph.get(c1).add(c2);
                        break;
                    }
                }
            }

            Set<Character> visiting = new HashSet<>();
            Set<Character> visited = new HashSet<>();

            StringBuilder order = new StringBuilder();

            for (char ch : graph.keySet()) {

                if (!visited.contains(ch)) {

                    if (dfs(ch, graph, visiting, visited, order)) {
                        return ""; // cycle found
                    }
                }
            }

            return order.reverse().toString();
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(
                sol.alienOrder(
                        new String[]{"wrt", "wrf", "er", "ett", "rftt"}
                )
        );
    }
}

    */

   /*

   import java.util.*;

public class AlienDictionary {

    static class Solution {

        public String alienOrder(String[] words) {

            Map<Character, Set<Character>> graph = new HashMap<>();
            Map<Character, Integer> indegree = new HashMap<>();

            // Add all characters
            for (String word : words) {
                for (char ch : word.toCharArray()) {
                    graph.putIfAbsent(ch, new HashSet<>());
                    indegree.putIfAbsent(ch, 0);
                }
            }

            // Build graph
            for (int i = 1; i < words.length; i++) {

                String w1 = words[i - 1];
                String w2 = words[i];

                // Invalid prefix case
                if (w1.length() > w2.length() && w1.startsWith(w2)) {
                    return "";
                }

                int minLen = Math.min(w1.length(), w2.length());

                for (int j = 0; j < minLen; j++) {

                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);

                    if (c1 != c2) {

                        if (!graph.get(c1).contains(c2)) {
                            graph.get(c1).add(c2);
                            indegree.put(c2, indegree.get(c2) + 1);
                        }

                        break;
                    }
                }
            }

            Queue<Character> q = new LinkedList<>();

            for (char ch : indegree.keySet()) {
                if (indegree.get(ch) == 0) {
                    q.offer(ch);
                }
            }

            StringBuilder ans = new StringBuilder();

            while (!q.isEmpty()) {

                char cur = q.poll();
                ans.append(cur);

                for (char nei : graph.get(cur)) {

                    indegree.put(nei, indegree.get(nei) - 1);

                    if (indegree.get(nei) == 0) {
                        q.offer(nei);
                    }
                }
            }

            // Cycle exists
            if (ans.length() != indegree.size()) {
                return "";
            }

            return ans.toString();
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(
                sol.alienOrder(
                        new String[]{"wrt", "wrf", "er", "ett", "rftt"}
                )
        );
    }
}
    
   */
}
