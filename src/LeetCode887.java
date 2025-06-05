import java.util.Arrays;

public class LeetCode887 {
    // 备忘录
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        // 初始化一个dp()函数不可能得到的默认值，负数不可能得到
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dp(k, n);
    }

    // 定义：手握 K 个鸡蛋，面对 N 层楼，最少的扔鸡蛋次数为 dp(K, N)
    private int dp(int k, int n) {
        // base case
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        // 查备忘录避免冗余计算
        if (memo[k][n] != -1) {
            return memo[k][n];
        }

        // 状态转移方程
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++) {
//            // 在所有楼层进行尝试，取最少扔鸡蛋次数
//            res = Math.min(res,
//                    // 碎和没碎取最坏情况
//                    Math.max(dp(k - 1, i - 1), dp(k, n - i)) + 1
//            );
//        }

        // 用二分搜索代替线性搜索
        int res = Integer.MAX_VALUE;
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // 鸡蛋在第 mid 层碎了和没碎两种情况
            int broken = dp(k - 1, mid - 1);
            int not_broken = dp(k, n - mid);
            // res = min(max(碎，没碎) + 1)
            if (broken > not_broken) {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res, not_broken + 1);
            }
        }
        // 结果存入备忘录
        memo[k][n] = res;
        return res;
    }
}
