import java.util.Arrays;

public class LeetCode740 {
    public static class solution1{
        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            // dp[i] 表示num[i...]获得的最大点数
            int[] dp = new int[n + 1];
            dp[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                // num[i]时有两种选择，获得nums[i],或者不获得nums[i]
                // 选择获得nums[i]。先加上与nums[i] 相同的元素，再排除与nums[i] + 1相等的元素
                int choice1 = nums[i];
                int nextIndex = i + 1;
                while (nextIndex < n && nums[i] == nums[nextIndex]) {
                    choice1 += nums[nextIndex];
                    nextIndex++;
                }
                while (nextIndex < n && nums[i] + 1 == nums[nextIndex]) {
                    nextIndex++;
                }
                choice1 += dp[nextIndex];

                // 选择不获得nums[i]
                int choice2 = dp[i + 1];
                dp[i] = Math.max(choice1, choice2);
            }

            return dp[0];
        }
    }

    public static class solution2 {
        public int deleteAndEarn(int[] nums) {
            // 使用points[i] 记录所有nums[i]的分值。
            // 问题就转化为，当选择了points[i],就不可以选择points[i+1]和points[i-1],即变成了打家劫舍问题。
            int[] points = new int[10001];
            for (int num : nums) {
                points[num] += num;
            }
            return rob(points);
        }

        private int rob(int[] points) {
            int n = points.length;
            int dp_i_1 = 0, dp_i_2 = 0;
            for (int i = n - 1; i >= 0; i--) {
                int dp_i = Math.max(points[i] + dp_i_2, dp_i_1);
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i_1;
        }
    }
}
