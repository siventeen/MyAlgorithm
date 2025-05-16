import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        if (m == 1 && n == 1 && grid[0][0] == 0) {
            return 1;
        }
        // 八个方向
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        // 需要记录走过的路径，避免死循环
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 初始化队列，从 (0, 0) 出发
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        // 执行 BFS 算法框架
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                // 向八个方向扩散
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    // 确保相邻的这个坐标没有越界且值为 0 且之前没有走过
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 1) {
                        continue;
                    }
                    if (x == m - 1 && y == n - 1) {
                        return step;
                    }
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
