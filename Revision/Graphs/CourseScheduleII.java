package Revision.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Deque;
import java.util.ArrayDeque;


public class CourseScheduleII {
     class Solution {

    public boolean dfs(int key,Map<Integer,List<Integer>> graph,Set<Integer> visiting,Set<Integer> visited,Deque<Integer> order){

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
        order.addFirst(key);

        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] course : prerequisites){
            graph.computeIfAbsent(course[1],k->new ArrayList<>()).add(course[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Deque<Integer> order = new ArrayDeque<>();

        for(int key=0;key<numCourses;key++){
            if(!visited.contains(key)){
               if(dfs(key,graph,visiting,visited,order)) return new int[]{};
            }
        }

        if(order.size() != numCourses) return new int[]{};

        int[] res = new int[order.size()];

        for(int i=0;i<res.length;i++){
            res[i] = order.pollFirst();
        }

        return res;
    }
    }

    
}
