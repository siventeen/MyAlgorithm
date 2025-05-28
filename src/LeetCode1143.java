import java.util.Arrays;

public class LeetCode1143 {
    // 子顶向下求解
    public static class solution1{
        // 备忘录，消除重叠子问题
        int[][] memo;
        int m, n;
        public int longestCommonSubsequence(String text1, String text2) {
            m = text1.length();
            n = text2.length();
            memo = new int[m][n];
            // 备忘录值为 -1 代表未曾计算
            for (int[] arr : memo) {
                Arrays.fill(arr, -1);
            }
            // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
            return dp(text1, 0, text2, 0);
        }

        // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
        private int dp(String text1, int i, String text2, int j) {
            // base case
            if (i == m || j == n) {
                return 0;
            }
            // 如果之前计算过，则直接返回备忘录中的答案
            if (memo[i][j] != -1) return memo[i][j];

            // 根据 s1[i] 和 s2[j] 的情况做选择
            int res;
            if (text1.charAt(i) == text2.charAt(j)) {
                // s1[i] 和 s2[j] 必然在 lcs 中
                res = 1 + dp(text1, i + 1, text2, j + 1);
            } else {
                // s1[i] 和 s2[j] 至少有一个不在 lcs 中
                res = Math.max(dp(text1, i + 1, text2, j), dp(text1, i, text2, j + 1));
            }
            memo[i][j] = res;
            return res;
        }
    }


    // 子底向上求解
    public static class solution2{
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
            // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
            int dp[][] = new int[m + 1][n + 1];
            // base case: dp[0][..] = dp[..][0] = 0, 其实不用写for循环，因为int[]类型默认值就是0
            for (int i = 0; i <= m; i++) {
                dp[i][0] = 0;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = 0;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 现在 i 和 j 从 1 开始，所以要减一
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }

}
