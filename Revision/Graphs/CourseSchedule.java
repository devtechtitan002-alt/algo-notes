package Revision.Graphs;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class CourseSchedule {
    static class Solution {

    public boolean dfs(int key,Map<Integer,List<Integer>> graph,Set<Integer> visiting,Set<Integer> visited,List<Integer> order){

        if(visiting.contains(key)) return true;

        if(visited.contains(key)) return false;

        visiting.add(key);

        if(graph.containsKey(key)){
        for(int neighbors : graph.get(key)){
            if(dfs(neighbors,graph,visiting,visited,order)) return true;
        }
        }

        visiting.remove(key);

        visited.add(key);
        order.add(key);

        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        /*

        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> indegrees = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            indegrees.putIfAbsent(i,0);
        }

        for(int[] course : prerequisites){
            graph.computeIfAbsent(course[1],k->new ArrayList<>()).add(course[0]);
            indegrees.put(course[0],indegrees.get(course[0])+1);
        }

        List<Integer> order = new ArrayList<>();

        Queue<Integer> root = new ArrayDeque<>();

         for(int keys : indegrees.keySet()){
            if(indegrees.get(keys)==0) root.offer(keys);
        }

        while(!root.isEmpty()){

            int curr = root.poll();
            order.add(curr);

            if(graph.containsKey(curr)){

            for(int neighbors : graph.get(curr)){

                indegrees.put(neighbors,indegrees.get(neighbors)-1);

                if(indegrees.get(neighbors) == 0){
                    root.offer(neighbors);
                }
            }

            }

        }

         // Cycle exists
        if (order.size() != indegrees.size()) {
            return false;
        }

        return true;

        */

        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] course : prerequisites){
            graph.computeIfAbsent(course[1],k->new ArrayList<>()).add(course[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        List<Integer> order = new ArrayList<>();

         for(int key=0;key<numCourses;key++){
            if(!visited.contains(key)){
               if(dfs(key,graph,visiting,visited,order)) return false;
            }
        }

        if(order.size() != numCourses) return false;

        return true;
    }
    }


    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] course = {
            {1,0}
        };
        System.out.println(sol.canFinish(2,course));
    }
}
