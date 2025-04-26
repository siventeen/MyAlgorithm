import java.util.LinkedList;
import java.util.List;

public class LeetCode17 {

    // 每个数字到字母的映射
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        char[] letters = mapping[digit].toCharArray();
        for (char letter : letters) {
            sb.append(letter);
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
