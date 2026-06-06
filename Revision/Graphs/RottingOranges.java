package Revision.Graphs;
import java.util.Queue;
import java.util.ArrayDeque;

public class RottingOranges {
    static class Solution {

    int[][] DIRECTIONS = { {-1,0} , {0,-1} , {1,0} , {0,1} };

    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new ArrayDeque<>();

        // multi source bfs 
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }

        int totalMin = 0;

        while(!q.isEmpty()){

            int levelSize = q.size();

            boolean isRottenHappen = false;

            for(int i=0;i<levelSize;i++){
               
                int[] curr = q.poll();

                for(int[] dirs : DIRECTIONS){
                    int r = curr[0] + dirs[0];
                    int c = curr[1] + dirs[1];

                    if(r > -1 && r < grid.length && c > -1 && c < grid[0].length){
                        if(grid[r][c] == 1){
                            isRottenHappen = true;
                            grid[r][c] = 2;
                            q.add(new int[]{r,c});
                        }
                    }
                }
            }

            if(isRottenHappen) totalMin++;
        }

        // finally check if there any unrotten still there even after bfs completed
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               if(grid[i][j] == 1) return -1;
            }
        }

        return totalMin;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[][] grid = {
           {2,1,1},
           {0,1,1},
           {1,0,1}
        };

        int[][] grid1 = {
            {0,2}
        };

        System.out.println(sol.orangesRotting(grid1));
    }
}
