import org.omg.CORBA.portable.ValueInputStream;

import java.awt.*;
import java.util.*;
import java.util.List;

public class LeetCode339 {
    public static class Edge {
        public String node;
        public double weight;
        public Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 把equations抽象成一副图，用邻接矩阵表示
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0), b = equation.get(1);
            double weight = values[i];
            // 构建双向图
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(new Edge(b, weight));
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(b).add(new Edge(a, 1.0 / weight));
        }

        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            // BFS 遍历图，计算 start 到 end 的路径乘积
            res[i] = dfs(graph, query.get(0), query.get(1));
        }
        return res;
    }

    private double dfs(Map<String, List<Edge>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            // 不存在的节点，肯定无法到达
            return -1;
        }
        if (start.equals(end)) {
            return 1;
        }

        // BFS 标准框架
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        // key 变量名，value 记录从 start 到该节点的路径乘积
        Map<String, Double> weight = new HashMap<>();
        weight.put(start, 1.0);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            double curWeight = weight.get(cur);
            List<Edge> neighbors = graph.get(cur);
            for (Edge neighbor : neighbors) {
                if (visited.contains(neighbor.node)) {
                    continue;
                }
                double nextWeight = curWeight * neighbor.weight;
                if (neighbor.node.equals(end)) {
                    return nextWeight;
                }
                // 记录 visited
                visited.add(neighbor.node);
                // 更新路径乘积
                weight.put(neighbor.node, nextWeight);
                // 新节点加入队列继续遍历
                queue.offer(neighbor.node);
            }
        }
        return -1;
    }
}
