public class NumberofIslands {
    static class Solution {
    public void detectIslands(char[][] grid,int row,int col,int rowSize,int colSize){

        if( row < 0 || col < 0 || row >= rowSize || col >= colSize ||grid[row][col]=='0' || grid[row][col]=='2') return;

        grid[row][col]= '2';

        if(row<rowSize-1) detectIslands(grid,row+1,col,rowSize,colSize);

        if(col<colSize-1) detectIslands(grid,row,col+1,rowSize,colSize);

        if(row>0) detectIslands(grid,row-1,col,rowSize,colSize);

        if(col>0) detectIslands(grid,row,col-1,rowSize,colSize);

    }
    public int numIslands(char[][] grid) {
        int islandsCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0' || grid[i][j]=='2') continue;

                detectIslands(grid,i,j,grid.length,grid[0].length);

                islandsCount++;
            }
        }
        return islandsCount;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        char[][] islands = {
           {'1','1','0','0','0'},
           {'0','0','0','0','0'},
           {'0','0','1','0','0'},
           {'0','0','0','1','1'}
        };
        System.out.println(sol.numIslands(islands));
    }
}

/*
import java.util.*;

public class NumberOfIslandsAll {

    // =========================
    // 1. DFS (RECURSION)
    // =========================
    public int numIslandsDFSRecursive(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfsRecursive(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsRecursive(char[][] grid, int row, int col) {

        // base condition
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // mark visited
        grid[row][col] = '0';

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int[] d : dirs) {
            dfsRecursive(grid, row + d[0], col + d[1]);
        }
    }


    // =========================
    // 2. DFS (ITERATIVE - STACK)
    // =========================
    public int numIslandsDFSIterative(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfsIterative(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsIterative(char[][] grid, int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int r = curr[0];
            int c = curr[1];

            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
                continue;
            }

            // mark visited
            grid[r][c] = '0';

            for (int[] d : dirs) {
                stack.push(new int[]{r + d[0], c + d[1]});
            }
        }
    }


    // =========================
    // 3. BFS (QUEUE)
    // =========================
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        // mark visited
        grid[row][col] = '0';

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] d : dirs) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];

                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {

                    queue.offer(new int[]{r, c});
                    grid[r][c] = '0';
                }
            }
        }
    }
}
*/
