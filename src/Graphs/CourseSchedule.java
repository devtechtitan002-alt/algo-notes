import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
public class CourseSchedule {
    static class Solution {

    public boolean dfs(int course,Map<Integer,List<Integer>> map,Set<Integer> set,Set<Integer> track){
        if(set.contains(course)) return true;

        if(!map.containsKey(course)) {
            set.add(course);
            return true;
        }

        if(track.contains(course)) return false;

        track.add(course);

        boolean hasCycle = true;

        for(int courses : map.get(course)){
            hasCycle = hasCycle && dfs(courses,map,set,track);
        }

        set.add(course);

        track.remove(course);

        return hasCycle && true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> track = new HashSet<>();

        for(int[] pre : prerequisites ){
            List dependencyList = map.getOrDefault(pre[0],new ArrayList<>());
            dependencyList.add(pre[1]);
            map.put(pre[0],dependencyList);
        }

         for(int i=0;i<numCourses;i++){

            if(!map.containsKey(i)){
                set.add(i);
                continue;
            }

            if(!dfs(i,map,set,track)) return false;
        }

        return true;

    }

    /*
    
class Solution {

    public boolean dfs(int course,
                       Map<Integer, List<Integer>> map,
                       Set<Integer> completed,
                       Set<Integer> visiting) {

        // already processed
        if (completed.contains(course)) return true;

        // no prerequisites
        if (!map.containsKey(course)) {
            completed.add(course);
            return true;
        }

        // cycle detected
        if (visiting.contains(course)) return false;

        visiting.add(course);

        for (int next : map.get(course)) {
            if (!dfs(next, map, completed, visiting)) {
                return false; // early exit on cycle
            }
        }

        visiting.remove(course);
        completed.add(course); // mark fully processed

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        // build graph
        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[0], k -> new ArrayList<>())
               .add(pre[1]);
        }

        Set<Integer> completed = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();

        // check all courses
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, completed, visiting)) {
                return false;
            }
        }

        return true;
    }
}
     */
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] pre = {
            {1,0},
            {0,1}
        };

        System.out.println(sol.canFinish(2,pre));
    }
}
