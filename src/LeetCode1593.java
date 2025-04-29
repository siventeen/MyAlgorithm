import java.util.HashSet;
import java.util.Set;

public class LeetCode1593 {
    int res = 0;
    Set<String> subStringSet = new HashSet<>();
    int splitLen = 0;
    public int maxUniqueSplit(String s) {
        backtrack(s, 0, 0);
        return res;
    }

    private void backtrack(String s, int start, int index) {
        if (index == s.length()) {
            // 字符串是否所有子串都放进了集合
            if (splitLen == s.length()) {
                res = Math.max(res, subStringSet.size());
            }
            return;
        }

        // 做切割
        String subString = s.substring(start, index + 1);
        if (!subStringSet.contains(subString)) {
            subStringSet.add(subString);
            splitLen += subString.length();
            backtrack(s, index + 1, index + 1);
            splitLen -= subString.length();
            subStringSet.remove(subString);
        }

        // 不切割，直接
        backtrack(s, start, index + 1);

    }
}
