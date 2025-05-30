public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int m = sum / 2;

        // dp数组的定义，看nums是否能刚好放进大小为sum / 2的背包中
        boolean[][] dp = new boolean[n + 1][m + 1];
        // base case 当背包大小为0时，怎么都能把背包装满。
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - nums[i - 1] < 0) {
                    // 如果背包的大小放不下第i个物品，则不放入背包。
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果背包的大小能放下第i个物品，dp[i][j]=第i个物品放入背包||第i个物品不放入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][m];
    }
}
