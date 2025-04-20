import java.util.LinkedList;

public class LeetCode526 {
    private int res = 0;
    // 记录每个索引选择的元素
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean [] used;
    public int countArrangement(int n) {
        used = new boolean[n + 1];
        backtrack(n, 1);
        return res;
    }

    private void backtrack(int n, int index) {
        // 所有索引都选择了元素
        if (index > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (i % index != 0 && index % i != 0) {
                continue;
            }
            used[i] = true;
            path.add(i);
            backtrack(n, index + 1);
            path.pollLast();
            used[i] = false;
        }
    }
}
