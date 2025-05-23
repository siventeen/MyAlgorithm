import java.util.Arrays;

public class LeetCode322 {
    // 动态规划 回溯写法
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dp(coins, amount - coins[i]);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public static class solution2 {
        // 动态规划 dp数组写法
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 数组大小为 amount + 1，初始值也为 amount + 1,(amount + 1不可能达到，因为最少需要amount个硬币)
            Arrays.fill(dp, amount + 1);
            // base case
            dp[0] = 0;
            for (int curAmount = 1; curAmount <= amount; curAmount++) {
                // 内层 for 循环在求所有选择的最小值
                for (int coin : coins) {
                    int nextAmount = curAmount - coin;
                    // 子问题无解，跳过
                    if (nextAmount < 0) {
                        continue;
                    }
                    if (dp[nextAmount] == -1) {
                        continue;
                    }
                    dp[curAmount] = Math.min(dp[curAmount], dp[nextAmount] + 1);
                }
                if (dp[curAmount] == amount + 1) {
                    dp[curAmount] = -1;
                }
            }
            return dp[amount];
        }

    }
}
