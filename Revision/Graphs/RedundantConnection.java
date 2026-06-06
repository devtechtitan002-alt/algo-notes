package Revision.Graphs;
import java.util.Set;
import java.util.HashSet;

public class RedundantConnection {
     class Solution {

    public int findParent(int node,int[] parent){
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node],parent);
    }

    public int[] findRedundantConnection(int[][] edges) {

        // finding how many nodes
        Set<Integer> set = new HashSet<>();

        for(int[] nodes : edges){
            set.add(nodes[0]);
            set.add(nodes[1]);
        }

        // initialize parent and rank
        int[] parent = new int[set.size()+1];
        int[] rank = new int[set.size()+1];

        for(int i=1;i<set.size()+1;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] nodes : edges){

            int u = nodes[0];
            int v = nodes[1];

            int rootU = findParent(u,parent);
            int rootV = findParent(v,parent);

            if( rootU == rootV ) return new int[]{u,v};
            else if(rank[rootU] < rank[rootV]){
                parent[rootU] = rootV;
                rank[rootV] += rank[rootU];
            }
            else{
                parent[rootV] = rootU;
                rank[rootU] += rank[rootV];
            }
        }

        return new int[]{};
    }
}
}
