import java.util.*;

public class WordLadder {

    static class Solution {

        // build pattern map
        public void buildPatternMap(String word, Map<String, List<String>> map) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if (!wordList.contains(endWord)) return 0;

            Map<String, List<String>> map = new HashMap<>();

            // build patterns for all words
            buildPatternMap(beginWord, map);
            for (String word : wordList) {
                buildPatternMap(word, map);
            }

            // BFS
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            int level = 1;

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    String word = q.poll();

                    if (word.equals(endWord)) return level;

                    for (int j = 0; j < word.length(); j++) {
                        String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                        List<String> neighbors = map.getOrDefault(pattern, new ArrayList<>());

                        for (String next : neighbors) {
                            if (!visited.contains(next)) {
                                visited.add(next);
                                q.offer(next);
                            }
                        }
                    }
                }
                level++;
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> ladder = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(sol.ladderLength("hit","cog",ladder));
    }
}