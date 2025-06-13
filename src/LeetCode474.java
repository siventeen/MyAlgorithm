public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // dp[i][j][k] 表示前i个字符串，构成最多含j个0，k个1的最大子集长度
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            String curStr = strs[i - 1];
            int[] count = counter(curStr);
            int zeros = count[0];
            int ones = count[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j - zeros >= 0 && k - ones >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] counter(String s) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        return new int[]{zeros, ones};
    }
}
