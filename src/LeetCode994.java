import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 方向数组
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 把所有腐烂的橘子加入队列，作为 BFS 的起点
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // BFS 算法框架
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 取出当前层所有节点，往四周扩散一层
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            time++;
        }
        // 检查是否还有新鲜橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        // 注意，当时间大于1时，需要减一才是最终结果
        return time == 0 ? 0 : time - 1;
    }
}
