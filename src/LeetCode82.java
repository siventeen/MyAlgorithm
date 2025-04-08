import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode82 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private Integer sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 通过排序保证相等数字在一起，在回溯过程中只遍历第一个相同元素
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    private void backTrack(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        // 剪枝、如果组合中元素的和大于或等于target则不需要再回溯
        if (sum >= target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            sum += candidates[i];
            path.add(candidates[i]);
            backTrack(candidates, target, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
