import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode784 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCasePermutation(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int index) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(c);
                backtrack(s, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(Character.toLowerCase(c));
                backtrack(s, i + 1);
                sb.deleteCharAt(sb.length() - 1);

                sb.append(Character.toUpperCase(c));
                backtrack(s, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
