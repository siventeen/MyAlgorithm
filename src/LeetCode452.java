import java.util.Arrays;

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        // 找最小射箭次数，其实就是找气球在x轴的最多不重叠区间
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // 最大不重叠区间数
        int count = 1;
        int endIndex = points[0][1];
        for (int i = 1; i < n; i++) {
            int start = points[i][0];
            if (start > endIndex) {
                count++;
                endIndex = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        LeetCode452 leetCode452 = new LeetCode452();
        leetCode452.findMinArrowShots(points);
    }
}
