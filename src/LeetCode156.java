public class LeetCode156 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp 数组的定义为：在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
        int[][] dp = new int[n][n];
        // base case，只包含一个字符的最长会问子序列长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 反着遍历保证正确的状态转移
        for (int i = n-2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        // 整个 s 的最长回文子串长度
        return dp[0][n - 1];
    }
}
