import java.util.HashSet;
import java.util.Set;

public class LeetCode694 {
    int res = 0;
    int n, m;
    int numDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Set<String> codeSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 0);
                    codeSet.add(sb.toString());
                }
            }
        }
        return codeSet.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int inNodeNum) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        // 记录进入节点时候的信息
        sb.append(inNodeNum).append('.');
        dfs(grid, i + 1, j, sb, 1);
        dfs(grid, i - 1, j, sb, 2);
        dfs(grid, i, j + 1, sb, 3);
        dfs(grid, i, j - 1, sb, 4);
        // 记录出节点时候的信息
        sb.append(-inNodeNum).append('.');
    }
}
