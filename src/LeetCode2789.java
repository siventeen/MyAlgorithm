public class LeetCode2789 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        // dp[i]表示 nums[i..] 合并后能取得的最大值。注意，合并后数组的最大值一定在左边第一个
        long[] dp = new long[n];
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= dp[i + 1]) {
                dp[i] = nums[i] + dp[i + 1];
            } else {
                dp[i] = nums[i];
            }
        }
        return dp[0];
    }
}
