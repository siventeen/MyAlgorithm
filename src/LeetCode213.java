public class LeetCode213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(robCompute(nums, 1, len - 1), robCompute(nums, 0, len - 2));
    }
    // 定义：返回闭区间 [start,end] 能抢到的最大值
    private int robCompute(int[] nums, int start, int end) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        for (int i = end; i >= start ; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[start];
    }
}
