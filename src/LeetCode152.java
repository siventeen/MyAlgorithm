public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // dp[i][0]表示以nums[i]结尾的乘积最大的连续子数组
        // dp[i][1]表示以nums[i]结尾的乘积最小的连续子数组
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

//        for (int i = 1; i < n; i++) {
//            if (nums[i] == 0) {
//                dp[i][0] = 0;
//                dp[i][1] = 0;
//            } else if (nums[i] < 0) {
//                dp[i][0] = nums[i] * dp[i - 1][1] < 0 ? nums[i] : nums[i] * dp[i - 1][1];
//                dp[i][1] = nums[i] * dp[i - 1][0] >= 0 ? nums[i] : nums[i] * dp[i - 1][0];
//            } else {
//                dp[i][0] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
//                dp[i][1] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
//            }
//        }

        // 简化版
        for (int i = 1; i < n; i++) {
            dp[i][0] = max(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1], nums[i]);
            dp[i][1] = min(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1], nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
