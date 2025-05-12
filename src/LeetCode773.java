import java.util.*;

public class LeetCode773 {
    int [][] neighborsIndexList;
    String target = "123450";

    public int slidingPuzzle(int[][] board) {
        neighborsIndexList = getNeighborsList(board.length, board[0].length);
        // 计算bfs算法的起点
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        // bfs算法框架开始
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        // 从起点开始搜索
        queue.offer(start);
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String cur = queue.poll();
                // 判断是否达到目标局面
                if (target.equals(cur)) {
                    return step;
                }
                // 将数字 0 和相邻的数字交换位置
                List<String> neighbors = getNeighbors(cur);
                for (String neighbor : neighbors) {
                    // 防止走回头路
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            step++;
        }
        // ****** BFS 算法框架结束 ******
        return -1;
    }

    private List<String> getNeighbors(String cur) {
        int zeroIndex = cur.indexOf('0');
        List<String> neighbors = new ArrayList<>();
        for (int neighborIndex : neighborsIndexList[zeroIndex]) {
            String neighbor = swap(cur, zeroIndex, neighborIndex);
            neighbors.add(neighbor);
        }
        return neighbors;
    }

    private String swap(String cur, int i, int j) {
        char[] chars = cur.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    private int[][] getNeighborsList(int m, int n) {
        int[][] neighborsIndexList = new int[m * n][];
        for (int i = 0; i < m * n; i++) {
            List<Integer> neighborsIndex = new ArrayList<>();
            // 如果不是第一列，有左侧邻居
            if (i % n != 0) {
                neighborsIndex.add(i - 1);
            }
            // 如果不是最后一列，有右侧邻居
            if (i % n != n - 1) {
                neighborsIndex.add(i + 1);
            }
            // 如果不是第一行，有上方邻居
            if (i - n >= 0) {
                neighborsIndex.add(i - n);
            }
            // 如果不是最后一行，有下方邻居
            if (i + n < m * n) {
                neighborsIndex.add(i + n);
            }

            neighborsIndexList[i] = neighborsIndex.stream().mapToInt(Integer::intValue).toArray();
        }

        return neighborsIndexList;
    }
}
