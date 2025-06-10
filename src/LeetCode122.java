public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 二维数组，dp[i][0] 表示第i天不持有股票获得的最大利润，dp[i][1] 表示第i天，持有股票获得的最大的利润。
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
