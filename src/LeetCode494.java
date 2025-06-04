public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 这两种情况，不可能存在合法的子集划分
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        return subSets(nums, (sum + target) / 2);
    }

    private int subSets(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        // base case当可选择物品个数为0，且目标数字为0时，有一种装法
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包的空间不足，只能选择不装物品 i
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选择物品i 和 不选择物品i两种结果之和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}
