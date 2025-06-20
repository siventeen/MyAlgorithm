import java.util.Arrays;

public class LeetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 移除的区间最少，也就是留下的不重叠区间最多
        int n = intervals.length;
        // 对intervals的end进行排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // 需要移除的区间数
        int count = 0;
        int endIndex = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            if (start >= endIndex) {
                endIndex = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
