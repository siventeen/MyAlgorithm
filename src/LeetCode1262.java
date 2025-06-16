public class LeetCode1262 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        // dp[i][j] 表示nums[0..i] 中，和 3 相除余数为 j 的最大和
        int[][] dp = new int[n + 1][3];

        // 没有元素相加时和为0，余数不可能为1或2
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int curNum = nums[i - 1];
            int yushu = curNum % 3;
            if (yushu == 0) {
                dp[i][0] = dp[i - 1][0] + curNum;
                dp[i][1] = dp[i - 1][1] + curNum;
                dp[i][2] = dp[i - 1][2] + curNum;
            } else if (yushu == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + curNum);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + curNum);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + curNum);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + curNum);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + curNum);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + curNum);
            }
        }

        return dp[n][0];
    }
}
