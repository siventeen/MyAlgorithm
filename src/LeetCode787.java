import jdk.nashorn.internal.runtime.linker.InvokeByName;

import java.util.*;

public class LeetCode787 {
    int src, dst;
    Map<Integer, List<int[]>> inDegreeMap = new HashMap<>();
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 把节点数转化为边数
        k++;
        this.src = src;
        this.dst = dst;
        memo = new int[n][k + 1];
        // 备忘录初始化为特殊值
        for (int[] arr : memo) {
            Arrays.fill(arr, -666);
        }
        // 使用map记录每个节点的入度信息
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            // 记录谁指向该节点，以及之间的权重
            inDegreeMap.putIfAbsent(to, new ArrayList<>());
            inDegreeMap.get(to).add(new int[]{from, price});
        }
        return dp(dst, k);
    }

    private int dp(int s, int k) {
        // base case 目的地就是终点时，不需要机票
        if (s == src) {
            return 0;
        }
        // 目的地不是终点 且边数为零时 说明该目的地无法到达，返回-1
        if (k == 0) {
            return -1;
        }
        if (memo[s][k] != -666) {
            return memo[s][k];
        }

        // s的入度节点列表
        List<int[]> inDegree = inDegreeMap.get(s);
        // 初始化为最大值，方便等会取最小值
        int res = Integer.MAX_VALUE;
        if (inDegree != null) {
            for (int[] v : inDegree) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的入度节点所需的最短路径权重
                int subSolution = dp(from, k - 1);
                // 跳过无解的情况
                if (subSolution != -1) {
                    res = Math.min(subSolution + price, res);
                }
            }
        }
        // 如果还是初始值，说明此节点不可达
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}
