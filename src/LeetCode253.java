import java.util.Arrays;

public class LeetCode253 {
    public int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] begins = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            begins[i] = meetings[i][0];
            ends[i] = meetings[i][1];
        }

        // 差分数组思路，对开始时间和结束时间分别排序，遇到一个开始时间计数加1，遇到一个结束时间计数减一
        Arrays.sort(begins);
        Arrays.sort(ends);

        int count = 0;
        int start = 0, end = 0;
        int res = 0;
        while (start < n || end < n) {
            if (begins[start] < ends[end]) {
                count++;
                start++;
            } else {
                count--;
                end++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
