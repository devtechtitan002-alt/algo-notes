import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
class CourseScheduleII{
    static class Solution {
    public boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> completed, Set<Integer> visiting, Stack<Integer> stack) {

        // already processed
        if (completed.contains(course)) return true;

        // no prerequisites
        if (!map.containsKey(course)) {
            completed.add(course);
            stack.push(course);
            return true;
        }

        // cycle detected
        if (visiting.contains(course)) return false;

        visiting.add(course);

        for (int next : map.get(course)) {
            if (!dfs(next, map, completed, visiting,stack)) {
                return false; // early exit on cycle
            }
        }

        visiting.remove(course);
        completed.add(course); // mark fully processed
        stack.push(course); // ordering

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        // build graph
        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[1], k -> new ArrayList<>())
               .add(pre[0]);
        }

        Set<Integer> completed = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        Stack<Integer> ordering = new Stack<>();

        // check all courses
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, completed, visiting,ordering)) {
                return new int[]{};
            }
        }

        int[] res = new int[ordering.size()];

        int idx=0;

        while(!ordering.isEmpty()){
            res[idx++] = ordering.pop();
        }

        return res;

    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] pre = {
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };
        System.out.println(Arrays.toString(sol.findOrder(4,pre)));
    }
}