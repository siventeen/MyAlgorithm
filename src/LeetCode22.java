import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    private List<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backTracking(0, 0, n);
        return res;
    }

    private void backTracking(int left, int right, int n) {
        // left 表示已经用过的左括号数量，right 表示已经用过的右括号数量
        if (left > n || right > n) {
            return;
        }
        if (right > left) {
            return;
        }
        if (left == n && right == n) {
            res.add(path.toString());
            return;
        }

        path.append("(");
        backTracking(left + 1, right, n);
        path.deleteCharAt(path.length() - 1);

        path.append(")");
        backTracking(left, right + 1, n);
        path.deleteCharAt(path.length() - 1);

    }
}
