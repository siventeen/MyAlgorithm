public class LeetCode1049 {
    // 两块石头可以抵消重量，求最后一块石头的最小重量。
    // 其实就是把这堆石头分成两个子集，使得这两个子集的重量差最小。
    // 即子集的重量接近与sum/2
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        // dp[i][j] 表示对于1到i块石头，背包大小为j的情况下最大能装的重量。
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            int curStone = stones[i - 1];
            for (int j = 1; j <= target; j++) {
                if (j >= curStone) {
                    dp[i][j] = Math.max(curStone + dp[i - 1][j - curStone], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[n][target];
    }
}
