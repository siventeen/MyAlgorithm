import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // dp[i] 表示以nums[i]结尾的最大整除子集
        List<Integer>[] dp = new List[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
        }
        // base case
        dp[0].add(nums[0]);
        for (int i = 1; i < n; i++) {
            int maxLen = -1;
            int maxIndex = -1;
            // 在 nums[0..i-1] 中寻找那个 nums[i] 能接到结尾的最长子序列
            for (int j = 0; j < i; j++) {
                List<Integer> list = dp[j];
                int maxNum = list.get(list.size() - 1);
                if (nums[i] % maxNum == 0) {
                    if (list.size() > maxLen) {
                        maxLen = list.size();
                        maxIndex = j;
                    }
                }
            }
            // nums[0..i-1] 中最长的那个子序列，再加上 nums[i]，
            // 就是 nums[0..i] 最长的子序列
            if (maxIndex != -1) {
                dp[i].addAll(dp[maxIndex]);
                dp[i].add(nums[i]);
            } else {
                dp[i].add(nums[i]);
            }
        }

        int maxLen = -1;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i].size() > maxLen) {
                maxLen = dp[i].size();
                maxIndex = i;
            }
        }
        return dp[maxIndex];
    }
}
