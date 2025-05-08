import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode301 {
    int max = 0;
    int pairs = 0;
    StringBuilder path = new StringBuilder();
    Set<String> res = new HashSet<>();
    int r = 0, l = 0;

    public List<String> removeInvalidParentheses(String s) {
        int score = 0;
        // 计算合法字符串最大长度
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                score ++;
            } else if (s.charAt(i) == ')') {
                if (score == 0) {
                    continue;
                } else {
                    score --;
                    max += 2;
                    pairs++;
                }
            } else {
                max++;
            }
        }
        backtrack(s, 0);
        if (max == 0) {
            res.add("");
        }
        return new ArrayList<>(res);
    }

    private void backtrack(String s, int start) {
        if (path.length() == max) {
            res.add(path.toString());
            return;
        }
        if (start == s.length()) {
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (r < pairs) {
                    path.append(s.charAt(i));
                    r++;
                    backtrack(s, i + 1);
                    path.deleteCharAt(path.length() - 1);
                    r--;
                } else {
                    backtrack(s, i + 1);
                }

            } else if (s.charAt(i) == ')') {
                if (l < pairs && l < r) {
                    path.append(s.charAt(i));
                    l++;
                    backtrack(s, i + 1);
                    path.deleteCharAt(path.length() - 1);
                    l--;
                } else {
                    backtrack(s, i + 1);
                }
            } else {
                path.append(s.charAt(i));
                backtrack(s, i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public class solution2 {
        Set<String> set = new HashSet<>();
        // max表示左括号和右括号的最大数量
        int n, max, len;
        String s;
        public List<String> removeInvalidParentheses(String _s) {
            s = _s;
            n = s.length();
            int score = 0;
            // 计算合法字符串最大长度
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    score ++;
                } else if (s.charAt(i) == ')') {
                    if (score == 0) {
                        continue;
                    } else {
                        score --;
                        max ++;
                    }
                }
            }
            dfs(0, "", 0);
            return new ArrayList<>(set);
        }
        void dfs(int index, String cur, int score) {
            if (score < 0 || score > max) return ;
            if (index == n) {
                if (score == 0 && cur.length() >= len) {
                    if (cur.length() > len) set.clear();
                    len = cur.length();
                    set.add(cur);
                }
                return ;
            }
            char c = s.charAt(index);
            if (c == '(') {
                dfs(index + 1, cur + String.valueOf(c), score + 1);
                dfs(index + 1, cur, score);
            } else if (c == ')') {
                dfs(index + 1, cur + String.valueOf(c), score - 1);
                dfs(index + 1, cur, score);
            } else {
                dfs(index + 1, cur + String.valueOf(c), score);
            }
        }

    }


    public static void main(String[] args) {
        String s = "((((((((((((((((((((aaaaa";
        LeetCode301 lc = new LeetCode301();
        List<String> res = lc.removeInvalidParentheses(s);
        System.out.println(res);
    }
}
