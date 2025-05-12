import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeetCode2850 {
    // 空白格子的index（编码后）
    List<Integer> blankList = new ArrayList<>();
    // 多余格子的index（编码后）
    List<Integer> stoneList = new ArrayList<>();
    // 当前路径长度
    int path  = 0;
    int ans = Integer.MAX_VALUE;
    boolean[] used;
    public int minimumMoves(int[][] grid) {
        // 获取空白格子和多余石头的index
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int count = grid[i][j];
                if (count > 1) {
                    while (count > 1) {
                        count--;
                        int code = i * 3 + j;
                        stoneList.add(code);
                    }
                }

                if (count == 0) {
                    blankList.add(i * 3 + j);
                }
            }
        }
        used = new boolean[blankList.size()];
        backtrack(0);
        return ans;
    }

    private void backtrack(int blankIndex) {
        // 空白格子放完石头，返回
        if (blankIndex == blankList.size()) {
            ans = Math.min(ans, path);
            return;
        }
        // 当前空白格子放石头的最小距离
        int min  = Integer.MAX_VALUE;
        for (int i = 0; i < stoneList.size(); i++) {
            if (used[i]) {
                continue;
            }
            // 同一个格子的石头放到当前空白格子，则跳过
            if (i > 0 && Objects.equals(stoneList.get(i), stoneList.get(i - 1)) && !used[i - 1]) {
                continue;
            }
            // 计算石头与空白格子的距离
            int distance = moveCheck(blankIndex, i);
            // 如果距离大于当前最小距离，则跳过
            if (distance > min) {
                continue;
            }
            min = distance;
            used[i] = true;
            path += distance;
            backtrack(blankIndex + 1);
            path -= distance;
            used[i] = false;
        }

    }

    private int moveCheck(int blankIndex, int stoneIndex) {
        int blankCode = blankList.get(blankIndex);
        int stoneCode = stoneList.get(stoneIndex);
        return Math.abs(blankCode / 3 - stoneCode / 3) + Math.abs(blankCode % 3 - stoneCode % 3);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{1,1,1},{1,2,1}};
        LeetCode2850 leetCode2850 = new LeetCode2850();
        System.out.println(leetCode2850.minimumMoves(grid));
    }
}
