public class LeetCode518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp[i][j] 表示对于前i种硬币，有dp[i][j]种组合能凑出金额j
        int[][] dp = new int[n + 1][amount + 1];
        // base case 当总金额为0时，只有什么都不做才能凑出，所以dp[i][0] = 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 状态转移方程
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
