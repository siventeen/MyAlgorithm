public class LeetCode1020 {
    int res = 0;

    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            // 淹没左边界，不计数
            dfs(grid, i, 0, true);
            // 淹没右边界，不计数
            dfs(grid, i, m - 1, true);
        }
        for (int j = 0; j < m; j++) {
            // 淹没上边界，不计数
            dfs(grid, 0, j, true);
            // 淹没下边界，不计数
            dfs(grid, n - 1, j, true);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(grid, i, j, false);
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, boolean isBorder) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        if (!isBorder) {
            res++;
        }
        dfs(grid, i + 1, j, isBorder);
        dfs(grid, i - 1, j, isBorder);
        dfs(grid, i, j + 1, isBorder);
        dfs(grid, i, j - 1, isBorder);
    }
}
