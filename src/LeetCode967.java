import java.util.ArrayList;
import java.util.List;

public class LeetCode967 {
    List<Integer> res = new ArrayList<>();
    int number = 0;
    public int[] numsSameConsecDiff(int n, int k) {
        if (k > 9 || k < 0) {
            return new int[]{};
        }
        backtrack(n, k, 0);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void backtrack(int n, int k, int cur) {
        if (cur == n) {
            res.add(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (n > 1 && cur == 0 && i == 0) {
                continue;
            }
            if (cur > 0 && Math.abs(number % 10 - i) != k) {
                continue;
            }
            number = number * 10 + i;
            backtrack(n, k, cur + 1);
            number /= 10;
        }

    }
}
