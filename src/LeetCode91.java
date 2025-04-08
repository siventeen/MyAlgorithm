public class LeetCode91 {
}
class Solution91_dp {
    public int numDecodings(String s) {
        int n = s.length();
        //dp[i]表示字符串 ss 的前 ii 个字符 s[1..i]s[1..i] 的解码方法数。
        int[] dp = new int[n + 1];
        //动态规划的边界条件为：dp[0] = 1,即空字符串可以有 11 种解码方法，解码出一个空字符串。
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
