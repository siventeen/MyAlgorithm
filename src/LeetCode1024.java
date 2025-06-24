import java.util.Arrays;

public class LeetCode1024 {
    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;
        Arrays.sort(clips, (a, b) ->{
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int startTime = clips[0][0];
        int endTime = clips[0][1];
        int count = 1;
        // 如果最小开始时间不能覆盖0时间点，则之间返回-1
        if (startTime > 0) {
            return -1;
        }
        for (int i = 1; i < n; i++) {
            int maxEndTime = endTime;
            // 如果最大结束时间已经覆盖目标时间，则返回视频片段数
            if (maxEndTime >= time) {
                return count;
            }
            // 在区间内选择结束时间最长的时间点
            while (i < n && clips[i][0] <= endTime) {
                if (clips[i][1] > maxEndTime) {
                    maxEndTime = clips[i][1];
                }
                i++;
            }
            // for循环和while i++重复了，抵消一次
            i--;
            if (maxEndTime == endTime) {
                return -1;
            }
            // 片段数加一，更新最大结束时间
            count++;
            endTime = maxEndTime;
        }
        // 如果结束时间能覆盖time则返回count，否则不能拼接出视频返回-1
        return endTime >= time ? count : -1;
    }
}
