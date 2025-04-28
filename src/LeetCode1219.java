public class LeetCode1219 {
    // 记录访问过的位置
    boolean[][] used;
    int m, n;
    // 存储矩阵，减少递归入参
    int[][] grid;
    // 记录路径和
    int pathSum = 0;
    // 最大路径和
    int res  = 0;
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        used = new boolean[m][n];
        // 以每个位置为起点，尝试穷举所有路径并记录路径和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(i, j);
            }
        }
        return res;
    }

    private void backtrack(int i, int j) {
        // 边界
        if (i >= m || j >= n || i < 0 || j < 0) {
            return;
        }
        // 走过了
        if (used[i][j]) {
            return;
        }
        // 0不能走
        if (grid[i][j] == 0) {
            return;
        }
        // 做选择
        used[i][j] = true;
        pathSum += grid[i][j];
        res = Math.max(res, pathSum);
        // 上下左右遍历路径
        backtrack(i - 1, j);
        backtrack(i, j - 1);
        backtrack(i + 1, j);
        backtrack(i, j + 1);
        //撤销选择
        used[i][j] = false;
        pathSum -= grid[i][j];
    }
}
