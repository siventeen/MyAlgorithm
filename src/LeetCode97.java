public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), t = s3.length();
        if (m + n != t) {
            return false;
        }

        // dp[i][j] 表示s1的前i个字符与s2的前j个字符能够组成s3的前i+j个字符。
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(p)) {
                    dp[i][j] = dp[i-1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(p)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
