public class LeetCode343 {
    public int integerBreak(int n) {
        // dp[i] 表示正整数1拆分成k个正整数后的最大乘积。
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                res = Math.max(res, temp);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
