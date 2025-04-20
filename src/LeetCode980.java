public class LeetCode980 {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        LeetCode980 leetCode980 = new LeetCode980();
        System.out.println(leetCode980.uniquePathsIII(grid));
    }

    int availableNum = 0;
    int res = 0;
    int n, m;
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        // 统计0的个数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    availableNum++;
                }
            }
        }
        // 找到起点，并开始回溯
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    backtrack(grid, i, j, 0);
                }
            }
        }
        return res;
    }

    public void backtrack(int[][] grid, int i, int j, int count) {
        // 边界判断
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        // 如果该节点是终点，且所有可走过节点已访问过，则可用路径加一，返回
        if (grid[i][j] == 2 && count == availableNum) {
            res++;
            return;
        }
        // 如果该节点为障碍或终点则返回
        if (grid[i][j] == -1 || grid[i][j] == 2) {
            return;
        }
        // 如果当前节点是0，则已访问的可走过节点加一
        if (grid[i][j] == 0) {
            count++;
        }

        // 标记当前节点为已访问
        grid[i][j] = -1;
        backtrack(grid, i + 1, j, count);
        backtrack(grid, i - 1, j, count);
        backtrack(grid, i, j + 1, count);
        backtrack(grid, i, j - 1, count);
        grid[i][j] = 0;
    }
}
