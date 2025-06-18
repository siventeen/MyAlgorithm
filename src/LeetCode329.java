public class LeetCode329 {
    // 备忘录，避免重复计算，初始化为 0
    // 定义：memo[i][j] 表示从 (i, j) 出发的最长递增路径长度
    int[][] memo;
    int m, n;
    // 方向数组，方便遍历上下左右四个相邻格子
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        this.matrix = matrix;
        int res = 0;
        // 以每个点为起点进行搜索
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp(i, j));
            }
        }
        return res;
    }

    // 定义：函数返回以 matrix[i][j] 为起点的最长递增路径长度
    private int dp(int i, int j) {
        if (memo[i][j] != 0) {
            // 如果已经计算过，直接返回
            return memo[i][j];
        }
        // 递增路径长度至少为 1，即自身
        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            // 如果越界，跳过
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            // 如果递增，继续穷举（状态转移）
            // 从 (i, j) 出发的最长递增路径 = max(从四个相邻位置出发的最长递增路径的最大值 + 1)
            if (matrix[x][y] > matrix[i][j]) {
                res = Math.max(res, dp(x, y) + 1);
            }
        }
        // 记录备忘录
        memo[i][j] = res;
        return res;
    }
}
