import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class RedundantConnection {
    static class Solution {
    int[] parent;
    int[] rank;
    List<int[]> list = new ArrayList<>();

    public int find(int x){
    if(parent[x] != x)
        parent[x] = find(parent[x]); // path compression
    return parent[x];
    }

    public void union(int x, int y){
    int px = find(x), py = find(y);
    if(px == py) {
        list.add(new int[]{x,y}); // just return is enough no list needed
        return;
    }
    if(rank[px] < rank[py]) parent[px] = py;
    else if(rank[px] > rank[py]) parent[py] = px;
    else { parent[py] = px; rank[px]++; }
    }
    public int[] findRedundantConnection(int[][] edges) {

        parent = new int[edges.length+1];
        rank = new int[edges.length+1];

        for(int i=0;i<edges.length;i++){
            parent[i]=i;
        }

        for(int[] joins : edges){
           union(joins[0],joins[1]);
        }

        return list.get(list.size()-1);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] edges = {
            {1,2},
            {1,3},
            {2,3}
        };
        System.out.println(Arrays.toString(sol.findRedundantConnection(edges)));
    }
}
