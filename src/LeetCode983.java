import java.util.Arrays;

public class LeetCode983 {
    int[] memo;
    int n;
    int[] days;
    int[] costs;
    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        this.days = days;
        this.costs = costs;
        return dp(0);
    }

    // dp方法返回 days[today...] 花费的最低票价
    private int dp(int index) {
        if (index >= n) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        // 买一天的通行证
        int buy1 = costs[0] + dp(index + 1);

        // 买七天的通行证
        int nextIndex = index + 1;
        int today = days[index];
        while (nextIndex < n && today + 6 >= days[nextIndex]) {
            nextIndex++;
        }
        int buy7 = costs[1] + dp(nextIndex);

        // 买30天的通行证
        while (nextIndex < n && today + 29 >= days[nextIndex]) {
            nextIndex++;
        }
        int buy30 = costs[2] + dp(nextIndex);

        memo[index] = min(buy1, buy7, buy30);
        return memo[index];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
