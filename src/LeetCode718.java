public class LeetCode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // dp[i][j] 表示nums1[i..]和nums[j..]之间的最长公共前缀
        int[][] dp = new int[m][n];

        // base case 因为从下到上，从右到左遍历，所以先初始化最后一行和最后一列的数据。
        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = nums1[i] == nums2[n - 1] ? 1 : 0;
            if (dp[i][n - 1] == 1) {
                res = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = nums1[m - 1] == nums2[i] ? 1 : 0;
            if (dp[m - 1][i] == 1) {
                res = 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
