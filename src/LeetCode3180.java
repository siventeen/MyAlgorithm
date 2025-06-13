import java.util.Arrays;

public class LeetCode3180 {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        // rewardValues 能得到的最大奖励为maxValue * 2 - 1
        int maxValue = rewardValues[n - 1];
        int target = 2 * maxValue - 1;
        // dp 用来标记能达到的奖励
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int reward : rewardValues) {
            for (int i = 0; i < reward; i++) {
                if (dp[i]) {
                    dp[i + reward] = true;
                }
            }
        }

        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}
