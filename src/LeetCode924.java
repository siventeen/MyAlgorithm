import java.util.*;

public class LeetCode924 {
    //题目让我们删除一个初始感染节点，使得最终感染的节点数最小，其实就是让我们找一个只有一个节点被感染的连通分量，且这个连通分量中的节点数最多。
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Set<Integer> initialSet = new HashSet<>();
        for (int i : initial) {
            initialSet.add(i);
        }
        // 因为题目要返回最小的节点编号，所以这里排个序，第一个找到的就是编号最小的
        Arrays.sort(initial);
        // 只要没有只包含一个节点的联通分量，则删除那个都不会减少M(initial)，所以删除那个都一样，按题目要求返回最小的节点
        int result = initial[0];
        // 减少的最多节点数·
        int maxReduceCount = 0;
        for (int badNode : initial) {
            // 寻找每个初始感染节点所在联通分量包含的节点数和初始感染节点数
            int[] bfsResult = bfs(graph, badNode, visited, initialSet);
            if (bfsResult[1] == 1 && bfsResult[0] > maxReduceCount) {
                result = badNode;
                maxReduceCount = bfsResult[0];
            }
        }

        return result;
    }

    private int[] bfs(int[][] graph, int badNode, boolean[] visited, Set<Integer> initialSet) {
        //初始感染节点所在联通分量包含的节点数
        int nodeNum = 0;
        //初始感染节点所在联通分量包含的初始感染节点数
        int badNodeNum = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(badNode);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            nodeNum++;
            if (initialSet.contains(cur)) {
                badNodeNum++;
            }
            for (int i = 0; i < graph.length; i++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
        return new int[]{nodeNum, badNodeNum};
    }
}
