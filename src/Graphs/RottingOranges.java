import java.util.Queue;
import java.util.LinkedList;
public class RottingOranges {
    static class Solution {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: count fresh + add all rotten
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        if(fresh == 0) return 0;

        int time = 0;

        // Step 2: BFS
        while(!q.isEmpty()){

            int size = q.size();
            boolean rottedThisMinute = false;

            for(int i=0;i<size;i++){
                int[] curr = q.poll();

                for(int[] d : directions){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if(r>=0 && c>=0 && r<rows && c<cols && grid[r][c]==1){
                        grid[r][c] = 2;
                        q.offer(new int[]{r,c});
                        fresh--;
                        rottedThisMinute = true;
                    }
                }
            }

            if(rottedThisMinute) time++;
        }

        return fresh == 0 ? time : -1;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        int[][] grid1 = {{0,2}};
        System.out.println(sol.orangesRotting(grid));
    }
}
