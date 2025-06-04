public class LeetCode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // dp[i][j] 表示从dungeon[i][j] 到达dungeon[m-1][n-1] 所需的最少血量
        int[][] dp = new int[m][n];
        // base case
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : -dungeon[m - 1][n - 1] + 1;
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] - dungeon[i][n - 1] > 0 ? dp[i + 1][n - 1] - dungeon[i][n - 1] : 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = dp[m - 1][i + 1] - dungeon[m - 1][i] > 0 ? dp[m - 1][i + 1] - dungeon[m - 1][i] : 1;
        }

        // 状态转移
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = min - dungeon[i][j] > 0 ? min - dungeon[i][j] : 1;
            }
        }

        return dp[0][0];
    }
}
