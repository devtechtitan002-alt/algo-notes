import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class PacificAtlanticWaterFlow {

    static public class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 🌊 Pacific (top row + left column)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);       // left
            dfs(heights, atlantic, i, n - 1);  // right
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);       // top
            dfs(heights, atlantic, m - 1, j);  // bottom
        }

        // 📦 Collect result
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        for (int[] d : dirs) {
            int r = row + d[0];
            int c = col + d[1];

            if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length)
                continue;

            // 🔥 reverse flow condition
            if (visited[r][c] || heights[r][c] < heights[row][col])
                continue;

            dfs(heights, visited, r, c);
        }
    }
}
}
