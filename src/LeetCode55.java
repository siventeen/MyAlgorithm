public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            // 不断计算能跳到的最远距离
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance <= i && i != n - 1) {
                // 可能碰到了 0，卡住跳不动了
                return false;
            }
        }
        return true;
    }
}
