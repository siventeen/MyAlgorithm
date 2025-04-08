public class LeetCode1254 {
    public int closedIsland(int[][] grid) {
        int res = 0;
        int n = grid.length, m = grid[0].length;
        for (int j = 0; j < m; j++) {
            //淹没上边界岛屿
            dfs(grid, 0, j);
            //淹没下边界岛屿
            dfs(grid, n - 1, j);
        }
        for (int i = 0; i < n; i++) {
            //淹没左边界岛屿
            dfs(grid, i, 0);
            //淹没右边界岛屿
            dfs(grid, i, m - 1);
        }

        // 计算剩余封闭岛屿
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    // 淹没岛屿
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);

    }
}
