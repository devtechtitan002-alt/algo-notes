package Revision.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


public class CloneGraph {

    static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


    static class Solution {

    public void dfs(Node node,Map<Node,Node> map,Set<Node> visited){

        if(visited.contains(node)) return;

        map.put(node,new Node(node.val));

        visited.add(node);

        for(Node nexts : node.neighbors){

            dfs(nexts,map,visited);
            if(map.containsKey(nexts)) map.get(node).neighbors.add(map.get(nexts)); 
            
        }

        return;

    }

    public Node cloneGraph(Node node) {

        if(node == null) return null;

        Map<Node,Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        dfs(node,map,visited);

        return map.get(node);
        
    }

    /*
     public Node cloneGraph(Node node) {
        var clonedByNode = new HashMap<Integer, Node>();

        return dfs(node, clonedByNode);
    }

    private Node dfs(Node node, HashMap<Integer, Node> clonedByMap) {
        if (node == null) return null;

        if (clonedByMap.containsKey(node.val)) {
            return clonedByMap.get(node.val);
        }

        var cloned = new Node(node.val);
        clonedByMap.put(node.val, cloned);

        for (var neighbor : node.neighbors) {
            cloned.neighbors.add(dfs(neighbor, clonedByMap));
        }

        return cloned;
    }
        
    */

}
}
