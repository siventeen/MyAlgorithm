import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        // 对信封宽度做升序排序，当宽度相同时，对高度做降序排序。这样可以保证在宽度上是可以嵌套的，并且递增序列里不会有相同的宽度。
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        // 对高度数组寻找 LIS
        int[] height = new int[len];
        for (int i = 0; i < len; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
        // dp[i] 表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }

    public static class solution2 {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            // 按宽度升序排列，如果宽度一样，则按高度降序排列
            Arrays.sort(envelopes, new Comparator<int[]>()
            {
                public int compare(int[] a, int[] b) {
                    return a[0] == b[0] ?
                            b[1] - a[1] : a[0] - b[0];
                }
            });
            // 对高度数组寻找 LIS
            int[] height = new int[n];
            for (int i = 0; i < n; i++)
                height[i] = envelopes[i][1];

            return lengthOfLIS(height);
        }


        /* 返回 nums 中 LIS 的长度 */
        public int lengthOfLIS(int[] nums) {
            int piles = 0, n = nums.length;
            int[] top = new int[n];
            for (int i = 0; i < n; i++) {
                // 要处理的扑克牌
                int poker = nums[i];
                int left = 0, right = piles;
                // 二分查找插入位置
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (top[mid] >= poker)
                        right = mid;
                    else
                        left = mid + 1;
                }
                if (left == piles) piles++;
                // 把这张牌放到牌堆顶
                top[left] = poker;
            }
            // 牌堆数就是 LIS 长度
            return piles;
        }
    }
}