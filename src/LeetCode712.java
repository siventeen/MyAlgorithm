import java.util.Arrays;

public class LeetCode712 {
    // 备忘录
    int[][] memo;
    int m, n;
    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    private int dp(String s1, int i, String s2, int j){
        int res = 0;
        // base case
        if (i == m) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < n; j++) {
                res += s2.charAt(j);
            }
            return res;
        }
        if (j == n) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < m; i++) {
                res += s1.charAt(i);
            }
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i + 1, s2, j), s2.charAt(j) + dp(s1, i, s2, j + 1));
        }

        return memo[i][j];
    }
}
