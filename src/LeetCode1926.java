import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // BFS 算法的队列和 visited 数组
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        // 启动 BFS 算法从 entrance 开始像四周扩散
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int queueSize = queue.size();
            // 扩散当前队列中的所有节点
            for (int i = 0; i < queueSize; i++) {
                int[] cur = queue.poll();
                // 每个节点都会尝试向上下左右四个方向扩展一步
                for (int[] dir : dirs) {
                    int[] next = new int[]{cur[0] + dir[0], cur[1] + dir[1]};
                    int x = next[0], y = next[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || maze[x][y] == '+') {
                        continue;
                    }
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                        // 走到边界（出口）
                        return step;
                    }
                    visited[x][y] = true;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}
