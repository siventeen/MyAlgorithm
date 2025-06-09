import java.util.Arrays;

public class LeetCode198 {
    public static class solution1 {
        int[] memo;
        public int rob(int[] nums) {
            int len = nums.length;
            memo = new int[len];
            Arrays.fill(memo, -1);
            return dp(nums, 0);
        }

        // dp函数计算nums[start...]所能打劫的最多钱
        private int dp(int[] nums, int start) {
            if (start >= nums.length) {
                return 0;
            }

            if (memo[start] != -1) {
                return memo[start];
            }
            // 只有两种选择，抢或不强， 抢的话下一家不能抢，所以是nums[start] + dp(nums, start + 2),不强的话，下一家可以抢，所以是dp(nums, start + 1)
            int res = Math.max(nums[start] + dp(nums, start + 2), dp(nums, start + 1));
            memo[start] = res;
            return res;
        }
    }

}
