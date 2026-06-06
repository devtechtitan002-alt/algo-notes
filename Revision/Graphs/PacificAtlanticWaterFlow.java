package Revision.Graphs;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;


public class PacificAtlanticWaterFlow {
    static class Solution {

    int[][] DIRECTIONS = { {-1,0} , {0,-1} , {1,0} ,{0,1} };  // UP LEFT DOWN RIGHT

    public void dfs(int row,int col,int[][] heights,Set<List<Integer>> set){

        if(set.contains(List.of(row,col))) return;

        set.add(List.of(row,col));

        for(int[] ordinates : DIRECTIONS){
            int r = row+ordinates[0];
            int c = col+ordinates[1];

            if(r>-1 && r<heights.length && c>-1 && c<heights[0].length && heights[row][col] <= heights[r][c] && !set.contains(List.of(r,c))){
                dfs(r,c,heights,set);
            }
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        for(int j=0;j<heights[0].length;j++){
            dfs(0,j,heights,pacific);      // top 
            dfs(heights.length-1,j,heights,atlantic);   // bottom
        }

        for(int i=0;i<heights.length;i++){
            dfs(i,0,heights,pacific);     // left borders
            dfs(i,heights[0].length-1,heights,atlantic);  // right border
        }

        List<List<Integer>> result = new ArrayList<>();
  
        for(List<Integer> pivots : pacific){
            int r = pivots.get(0);
            int c = pivots.get(1);
            if(atlantic.contains(List.of(r,c))) result.add(new ArrayList<>(List.of(r,c)));
        }

        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        
        for(List<Integer> list : sol.pacificAtlantic(heights)){
            System.out.println(list);
        }
    }
}
