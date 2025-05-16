import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        // 访问过的下标
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (arr[cur] == 0) {
                return true;
            }
            int right = cur + arr[cur];
            if (right < n && !visited[right]) {
                queue.offer(right);
                visited[right] = true;
            }

            int left = cur - arr[cur];
            if (left >= 0 && !visited[left]) {
                queue.offer(left);
                visited[left] = true;
            }
        }
        return false;
    }
}
