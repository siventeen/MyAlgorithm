import java.util.Arrays;

public class LeetCode10 {
    int m, n;
    int[][] memo;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        memo = new int[m][n];
        // 备忘录填充特殊值-1。 memo[i][j] = 0时，表示s[i..]和p[j..]不匹配，memo[i][j] = 1时，表示匹配。
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean res;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 判断p[j+1]是否是*
            if (j + 1 < n && p.charAt(j + 1) == '*') {
                // p[j]重复0次或者多次
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                // s和p都匹配下一个字符
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 判断p[j+1]是否是*
            if (j + 1 < n && p.charAt(j + 1) == '*') {
                // 匹配0次
                res = dp(s, i, p, j + 2);
            } else {
                // p[j+1]不是*，则直接返回false
                res = false;
            }
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
