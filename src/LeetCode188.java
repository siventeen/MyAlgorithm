public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        if (k > len / 2) {
            return maxProfit_k_inf(prices);
        }

        int max_k = k;
        int[][][] dp = new int[len][max_k + 1][2];

        for (int i = 0; i < len; i++)
            for (k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 i = -1 时的 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        return dp[len - 1][max_k][0];
    }

    private int maxProfit_k_inf(int[] price) {
        int len = price.length;
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -price[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price[i]);
        }
        return dp[len - 1][0];
    }
}
