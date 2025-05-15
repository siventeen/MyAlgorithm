import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 生成无向图，无向图等同于双向图
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 初始化叶子节点，即度为1的节点
        LinkedList<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        int  remainingNodes = n;
        while (remainingNodes > 2) {
            int size = leaves.size();
            remainingNodes -= size;
            for (int i = 0; i < size; i++) {
                int cur = leaves.poll();
                // 获取叶子结点相邻的节点（只有一个）
                int neighbor = graph.get(cur).get(0);
                // 删除相邻节点与叶子结点的度
                graph.get(neighbor).remove(Integer.valueOf(cur));
                // 如果删除后，相连节点的度为 1，说明它也变成了叶子节点
                if (graph.get(neighbor).size() == 1) {
                    leaves.offer(neighbor);
                }
            }
        }

        return leaves;
    }
}
