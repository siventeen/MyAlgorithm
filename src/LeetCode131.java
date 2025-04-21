import java.util.LinkedList;
import java.util.List;

public class LeetCode131 {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            // 叶子节点，s被分割成若干回文子串
            res.add(new LinkedList<>(path));
        }
        for (int i = start; i < s.length(); i++) {
            // 如果s[start...i]不是回文子串，则不能分割
            if (!check(s, start, i)) {
                continue;
            }
            // 做选择，把 s[start..i] 放入路径列表中
            path.addLast(s.substring(start, i + 1));
            // 进入回溯树的下一层，继续切分 s[i+1..]
            backtrack(s, i + 1);
            // 撤销选择
            path.pollLast();
        }
    }

    private boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
