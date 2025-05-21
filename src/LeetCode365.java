import java.net.Inet4Address;
import java.util.*;

public class LeetCode365 {
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<int[]> queue = new LinkedList<>();
        // 用来记录已经遍历过的状态，把元组转化成数字方便存储哈希集合
        // 转化方式是 (x, y) -> (x * (jug2Capacity + 1) + y)，和二维数组坐标转一维坐标是一样的原理
        // 因为水桶 2 的取值是 [0, jug2Capacity]，所以需要额外加一，请类比二维数组坐标转一维坐标
        // 且考虑到题目输入的数据规模较大，相乘可能导致 int 溢出，所以使用 long 类型
        Set<Long> visited = new HashSet<>();
        queue.add(new int[]{0, 0});
        visited.add(0L);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0], curY = cur[1];
            if (curX == target || curY == target || curX + curY == target) {
                return true;
            }

            // 计算出所有可能的下一个状态
            List<int[]> next = new ArrayList<>();
            // 把x桶灌满
            next.add(new int[]{x, curY});
            // 把y桶灌满
            next.add(new int[]{curX, y});
            // 把x桶倒空
            next.add(new int[]{0, curY});
            // 把y桶倒空
            next.add(new int[]{curX, 0});
            // 把x桶倒入y桶,直到y桶满了或者x桶空
            next.add(new int[]{curX - Math.min(curX, y - curY), curY + Math.min(curX, y - curY)});
            // 把y桶倒入x桶,直到x桶满了或者y桶空
            next.add(new int[]{curX + Math.min(curY, x - curX), curY - Math.min(curY, x - curX)});
            // 把所有可能的下一个状态都放进队列里
            for (int[] nxt : next) {
                long hash = (long) nxt[0] * (y+1) + nxt[1];
                if (!visited.contains(hash)) {
                    queue.add(new int[]{nxt[0], nxt[1]});
                    visited.add(hash);
                }
            }
        }
        return false;
    }
}
