import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class CloneGraph {
    class Node {
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
    class Solution {
    public Node cloneGraph(Node node) {
        if(node == null || node.neighbors == null) return null;
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node head = new Node(node.val);
        map.put(node.val,head);
        while(!q.isEmpty()){

            Node curr = q.poll();

            for(Node neighbors : curr.neighbors){
                if(!map.containsKey(neighbors.val)) {
                   q.add(neighbors);
                   map.put(neighbors.val,new Node(neighbors.val));
                }
                map.get(curr.val).neighbors.add(map.get(neighbors.val));
            }

        }
        return head;
    }
}
}
