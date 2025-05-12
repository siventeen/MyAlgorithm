import java.util.HashSet;

public class LeetCode1723 {
    // 记录所有分配方案中的「最大工作时间」的最小值
    int ans = Integer.MAX_VALUE;
    int[] workTime;
    public int minimumTimeRequired(int[] jobs, int k) {
        workTime = new int[k];
        backtrack(jobs, 0);
        return ans;
    }

    private void backtrack(int[] jobs, int index) {
        if (index == jobs.length) {
            // 找到一个分配方案
            // 计算当前分配方案下的最大工作时间
            int max = 0;
            for (int time : workTime) {
                max = Math.max(max, time);
            }
            ans = Math.min(ans, max);
            return;
        }
        // 从当前的 jobs[jobIdx] 来选择工人
        // 注意，这个 chosen 是一个关键的剪枝优化，具体看我在思路部分的解释
        HashSet<Integer> chosen = new HashSet<>();
        for (int i = 0; i < workTime.length; i++) {
            if (workTime[i] + jobs[index] >= ans) {
                // 剪枝优化：如果当前工人的工作时间加上当前的工作时间已经超过了当前的最优解，那么就不用继续尝试了
                continue;
            }
            if (chosen.contains(workTime[i])) {
                // 剪枝优化：如果前面曾有工人有这个 workload，则不必把当前工作分配给他
                continue;
            }

            chosen.add(workTime[i]);
            workTime[i] += jobs[index];
            backtrack(jobs, index + 1);
            workTime[i] -= jobs[index];
        }

    }
}
