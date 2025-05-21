import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode417 {
    // 最左侧、最上侧的格子一定可以流入太平洋，最右侧、最下侧的格子一定可以流入大西洋.
    // 可以把以最左侧、最上侧的格子为起点向内陆进行反向搜索，就可以很容易地算出来哪些格子可以流入太平洋；
    // 同理，我也可以把以最右侧、最下侧的格子为起点向内陆进行反向搜索，就可以很容易地算出来哪些格子可以流入大西洋。
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        // 记录能到达太平洋的格子
        boolean[][] pacific = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pacificQueue.add(new int[]{i, 0});
            pacific[i][0] = true;
        }
        for (int j = 1; j < n; j++) {
            pacificQueue.add(new int[]{0, j});
            pacific[0][j] = true;
        }
        // 进行 BFS 搜索，找出所有可以流入太平洋的格子
        bfs(heights, pacificQueue, pacific);

        // 记录能到达大西洋的格子
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            atlanticQueue.add(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            atlanticQueue.add(new int[]{m - 1, i});
            atlantic[m - 1][i] = true;
        }
        // 进行 BFS 搜索，找出所有可以流入大西洋的格子
        bfs(heights, atlanticQueue, atlantic);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 筛选出既可以流入太平洋又可以流入大西洋的格子
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y]) {
                    continue;
                }
                if (heights[x][y] >= heights[cur[0]][cur[1]]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
