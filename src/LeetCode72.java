import java.util.Arrays;
import java.util.Map;

public class LeetCode72 {
    // 自顶向上求解
    public static class solution1{
        int[][] memo;
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            // 备忘录初始化为特殊值，代表还未计算
            memo = new int[m][n];
            for (int[] arr : memo) {
                Arrays.fill(arr, -1);
            }
            return dp(word1, m - 1, word2, n - 1);
        }

        // 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
        public int dp(String word1, int i, String word2, int j) {
            // base case 当一个字符串走尽时，另一个字符串的剩余长度，就是需要返回的操作数
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;
            // 查备忘录，避免重叠子问题
            if (memo[i][j] != -1) return memo[i][j];

            // 状态转移，结果存入备忘录
            int res;
            if (word1.charAt(i) == word2.charAt(j)) {
                res = dp(word1, i - 1, word2, j - 1);
            } else {
                res = min(
                        dp(word1, i, word2, j - 1) + 1,
                        dp(word1, i - 1, word2, j) + 1,
                        dp(word1, i-1, word2, j-1) +1
                );
            }
            memo[i][j] = res;
            return res;
        }

        private int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }
    }

    // 自底向下求解
    public static class solution2 {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            // dp[i+1][j+1]存储  s1[0..i] 和 s2[0..j] 的最小编辑距离
            int[][] dp = new int[m + 1][n + 1];
            // base case
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = i;
            }

            // 自底向上求解
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + 1
                        );
                    }
                }
            }
            // 储存着整个 s1 和 s2 的最小编辑距离
            return dp[m][n];
        }

        private int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

    }

}
