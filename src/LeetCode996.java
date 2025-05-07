import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode996 {
    boolean[] used;
    LinkedList<Integer> path = new LinkedList<>();
    int ans = 0;
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return ans;
    }

    private void backtrack(int[] nums){
        if (path.size() == nums.length) {
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (path.size() > 0 && !check(path.getLast(), nums[i])) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums);
            path.pollLast();
            used[i] = false;
        }

    }

    private boolean check(int a, int b) {
        int sum = a + b;
        int c = (int) Math.sqrt(sum);
        return c * c == sum;
    }
}
