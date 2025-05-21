import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        // 初始化全部填充特殊值 -1，代表未计算，
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        // 初始化队列，把那些值为 0 的坐标放到队列里, 并将矩阵中值为0的位置在结果中置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }
        // 执行 BFS 算法框架，从值为 0 的坐标开始向四周扩散
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 向四周扩散
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                // 确保相邻的这个坐标没有越界且之前未被计算过
                if (x < 0 || x >= m || y < 0 || y >= n || res[x][y] != -1) {
                    continue;
                }
                res[x][y] = res[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{x, y});
            }
        }
        return res;
    }
}
