public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            // 总油量小于总的消耗，无解
            return -1;
        }
        // 记录油箱中的油量
        int tank = 0;
        // 记录起点
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // 无法从 start 到达 i + 1
                // 所以站点 i + 1 应该是起点
                tank = 0;
                start = i + 1;
            }
        }
        return start == n ? 0 : start;
    }
}
