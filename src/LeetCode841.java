import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode841 {
    // 方法一 dfs

    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms, 0);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int cur) {
        if (visited[cur]) {
            return;
        }

        visited[cur] = true;
        for (int room : rooms.get(cur)) {
            dfs(rooms, room);
        }
    }

    // 方法二 bfs
    public static class solution2 {
        boolean[] visited;
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                visited[cur] = true;
                for (int room : rooms.get(cur)) {
                    if (!visited[room]) {
                        queue.offer(room);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) return false;
            }
            return true;

        }
    }

}
