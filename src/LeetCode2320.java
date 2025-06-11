public class LeetCode2320 {
    public int countHousePlacements(int n) {
        int MOD = 1000000007;
        // dp[i] 表示从第1个地块到第i个，能放置房子的方式数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        return (int) ((long) dp[n] * dp[n] % MOD);
    }
}
