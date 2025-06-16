import java.util.List;

public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i] 遍历到某一行得下标i时，最小路径和。
        int[] dp = new int[n];
        if (n == 1) {
            return triangle.get(0).get(0);
        }

        // base case
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            int size = list.size();
            // 记录当前层的最小路径和
            int[] newDp = new int[n];
            for (int j = 0; j < size; j++) {
                // base case 下标为0时的最小路径和为第一层到当前层下标为0的和
                if (j == 0) {
                    newDp[j] = dp[j] + list.get(j);
                    continue;
                }
                // base case 最后一个下标的最小路径和，为第一层到当前层最后一个下标的和
                if (j == size - 1) {
                    newDp[j] = dp[j - 1] + list.get(j);
                    continue;
                }
                // 状态转移方程
                newDp[j] = list.get(j) + Math.min(dp[j], dp[j - 1]);
            }
            dp = newDp;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
