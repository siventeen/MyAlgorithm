import java.util.Arrays;
import java.util.TreeMap;

public class LeetCode1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        // 按结束时间排序
        Arrays.sort(jobs, (a,b) -> a[1] - b[1]);

        // dp[i]表示0到i的时间内，最多能获得的利润
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        // base case 0时间能获得的利润为0
        dp.put(0, 0);

        for (int[] job : jobs) {
            int start = job[0];
            int end = job[1];
            int pro = job[2];
            dp.put(end, Math.max(
                    // 选则这个job
                    dp.floorEntry(start).getValue() + pro,
                    // 不选这个job
                    dp.lastEntry().getValue()
            ));
        }

        return dp.lastEntry().getValue();
    }
}
