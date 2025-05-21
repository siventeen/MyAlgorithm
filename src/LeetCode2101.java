import java.util.*;

public class LeetCode2101 {

    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 初始化邻接表
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2) <= Math.pow(bombs[i][2], 2)) {
                    graph.get(i).add(j);
                }
            }
        }

        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            // 以节点 i 进行 BFS 遍历，返回可达的节点数量
            int num = bfs(graph, i);
            maxNum = Math.max(maxNum, num);
        }
        return maxNum;
    }

    private int bfs(List<List<Integer>> graph, int bomb) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(bomb);
        int num = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int cur = queue.poll();
                if (visited[cur]) {
                    continue;
                }
                visited[cur] = true;
                num++;
                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
            }
        }
        return num;
    }
}
