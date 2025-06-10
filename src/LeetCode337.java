public class LeetCode337 {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    // 返回一个二维数组
    // dp[0] 表示不抢root时，得到的最大钱数
    // dp[1] 表示抢劫root时，得到的最大钱数
    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // 不抢root
        int notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 抢root
        int robRoot = root.val + left[0] + right[0];

        return new int[]{notRobRoot, robRoot};
    }
}
