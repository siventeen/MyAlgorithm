public class LeetCode2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        // dp[i] 表示questions[i...][] 能获得的最大分数
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n-2; i >= 0; i--) {
            int point_i = questions[i][0];
            int brainpower_i = questions[i][1];
            // 对于questions[i]有两种选择，做或不做。if语句防止数组越界
            if (i + brainpower_i + 1 >= n) {
                dp[i] = Math.max(point_i, dp[i + 1]);
            } else {
                dp[i] = Math.max(point_i + dp[i + brainpower_i + 1], dp[i + 1]);
            }
        }
        return dp[0];
    }
}
