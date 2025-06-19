public class LeetCode45 {
    public int jump(int[] nums) {
        int n = nums.length;
        // 跳的步数
        int step = 0;
        // 区间的开始下标
        int start = 0;
        // 区间的结束下标
        int end = 0;
        // 跳跃step下所能达到的最远下标
        int maxIndex = 0;
        // 在不能达到n-1下标时，继续跳跃
        while (maxIndex < n - 1) {
            step++;
            // 再区间里计算能到达的最大下标
            for (int i = start; i <= end; i++) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
            // 更新区间
            start = end + 1;
            end = maxIndex;
        }
        return step;
    }
}
