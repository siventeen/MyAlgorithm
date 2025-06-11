public class LeetCode123 {
    public int maxProfit(int[] prices) {
        int max_k = 2;
        int len = prices.length;
        int[][][] dp = new int[len][max_k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int k = max_k; k > 0; k--) {
                if (i == 0) {
                    // 处理 base case
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][max_k][0];
    }
}
