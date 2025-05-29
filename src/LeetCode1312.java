public class LeetCode1312 {
    public int minInsertions(String s) {
        int n = s.length();
        // dp数组表示 使得s[i..j]变成回文子串需要插入的最少字符数为dp[i][j]
        // base case 当i = j 时，就是回文子串，不需要插入所以是0，i不可以大于j，所以二位数组的左下部分也为0
        int[][] dp = new int[n][n];

        // 从下到上，从左到右遍历数组
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
