import java.util.*;

public class AlienDictionary {

    static public class Solution {

        StringBuilder answer = new StringBuilder();

        // DFS with visited + cycle detection
        public boolean dfs(char ch,
                           Map<Character, List<Character>> map,
                           Set<Character> visiting,
                           Set<Character> visited) {

            if (visiting.contains(ch)) return false; // cycle ❌
            if (visited.contains(ch)) return true;   // already processed ✔

            visiting.add(ch);cha

            if (map.containsKey(ch)) {
                for (char next : map.get(ch)) {
                    if (!dfs(next, map, visiting, visited)) return false;
                }
            }

            visiting.remove(ch);
            visited.add(ch);
            answer.append(ch); // post-order

            return true;
        }

        // build graph (fixed)
        public boolean mapCharacters(String s1, String s2,
                                     Map<Character, List<Character>> map) {

            int len = Math.min(s1.length(), s2.length());

            for (int i = 0; i < len; i++) {

                if (s1.charAt(i) != s2.charAt(i)) {

                    map.computeIfAbsent(s1.charAt(i), k -> new ArrayList<>())
                       .add(s2.charAt(i)); // ALWAYS add edge ✔

                    return true; // only first mismatch matters ✔
                }
            }

            // prefix invalid case
            if (s1.length() > s2.length()) return false;

            return true;
        }

        public String dictionaryOrder(String[] wrd) {

            Map<Character, List<Character>> map = new HashMap<>();

            // include ALL characters
            Set<Character> allChars = new HashSet<>();
            for (String w : wrd) {
                for (char c : w.toCharArray()) {
                    allChars.add(c);
                }
            }

            // build graph
            for (int i = 0; i < wrd.length - 1; i++) {
                if (!mapCharacters(wrd[i], wrd[i + 1], map)) return "";
            }

            // DFS traversal
            Set<Character> visiting = new HashSet<>();
            Set<Character> visited = new HashSet<>();

            for (char ch : allChars) {
                if (!dfs(ch, map, visiting, visited)) return "";
            }

            // reverse result (important)
            return answer.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String[] dic = {"wrt","wrf","er","ett","rftt"};
        Solution sol = new Solution();
        System.out.println(sol.dictionaryOrder(dic));
    }
}