import java.util.Arrays;

public class LeetCode2611 {

    // 解法一：动态规划，超内存
    public static class solution1{
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int n = reward1.length;

            // dp[i][k] 表示第1到第i块奶酪中，第一只老鼠恰好吃k块奶酪的最大得分。
            int[][] dp = new int[n + 1][k + 1];
            // base case
            // k=0时，全部奶酪由第二只小鼠吃
            for (int i = 1; i <= n; i++) {
                dp[i][0] = reward2[i - 1] + dp[i - 1][0];
            }
            // k和n相等时，全部奶酪由第一只小鼠吃
            for (int i = 1; i <= k; i++) {
                dp[i][i] = dp[i - 1][i - 1] + reward1[i - 1];
            }
            // 当n==k时，直接返回
            if (n == k) {
                return dp[k][k];
            }
            // 分两种情况遍历，i<=k和i>k时
            for (int i = 2; i <= k; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.max(reward1[i-1] + dp[i-1][j-1], reward2[i-1] + dp[i-1][j]);
                }
            }
            for (int i = k+1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(reward1[i-1] + dp[i-1][j-1], reward2[i-1] + dp[i-1][j]);
                }
            }
            return dp[n][k];
        }
    }

    // 解法二：贪心算法
    public static class solution2{
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int n = reward1.length;

            // diff[i][0] 存reward1[i] - reward2[i] 的差值
            // diff[i][1] 存索引 i
            int[][] diff = new int[n][2];
            for (int i = 0; i < n; i++) {
                diff[i][0] = reward1[i] - reward2[i];
                diff[i][1] = i;
            }
            Arrays.sort(diff, (a, b) -> b[0] - a[0]);
            int res = 0;
            for (int i = 0; i < k; i++) {
                res += reward1[diff[i][1]];
            }
            for (int i = k; i < n; i++) {
                res += reward2[diff[i][1]];
            }
            return res;
        }
    }

}
