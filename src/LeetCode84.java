import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode84 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] used = null;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        // 通过排序保证相等数字在一起，在回溯过程中只遍历第一个相同元素
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums);
        return res;
    }

    private static void backTrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            // 减去同一高度相等元素的枝，但不减去同一路径中相同元素的枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteUnique(nums);
    }
}
