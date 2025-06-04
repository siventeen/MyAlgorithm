public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // dp[i][j] 表示从grid[0][0] 到grid[i][j]的最小路径和
        int[][] dp = new int[m][n];

        // base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
