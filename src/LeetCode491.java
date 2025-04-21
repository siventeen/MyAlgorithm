import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode491 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    private void backtrack(int[] nums, int startIndex) {
        if (path.size() > 1) {
            res.add(new LinkedList<>(path));
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 确保元素递增
            if (path.size() > 0 && path.getLast() > nums[i]) {
                continue;
            }

            // 避免同一层中的元素重复使用
            if (used.contains(nums[i])) {
                continue;
            }

            path.addLast(nums[i]);
            used.add(nums[i]);
            backtrack(nums, i + 1);
            path.pollLast();
        }
    }

}
