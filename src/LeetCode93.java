import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        // 分割结束，范湖
        if (start == s.length()) {
            // 如果分割成四段，加入结果
            if (path.size() == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 已经分割成4段了，直接返回
            if (path.size() == 4) {
                return;
            }
            // 校验是否满足ip中数字的规格
            if (!checkIp(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtrack(s, i + 1);
            path.pollLast();
        }
    }

    private boolean checkIp(String s, int start, int end) {
        int len = end - start + 1;
        if (len > 3 || len == 0) {
            return false;
        }
        if (s.charAt(start) == '0' && len > 1) {
            return false;
        }
        if (len == 3) {
            int num = Integer.parseInt(s.substring(start, end + 1));
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
