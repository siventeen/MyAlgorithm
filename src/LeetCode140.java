import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode140 {
    Set<String> wordDict;
    // 备忘录
    List<String>[] memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>();
        this.wordDict.addAll(wordDict);
        memo = new List[s.length()];
        return dp(s, 0);
    }

    // 定义：返回用 wordDict 构成 s[startIndex..] 的所有可能
    private List<String> dp(String s, int startIndex) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (startIndex == n) {
            res.add("");
            return res;
        }
        // 防止冗余计算
        if (memo[startIndex] != null) {
            return memo[startIndex];
        }

        // 遍历 s[startIndex..] 的所有前缀
        for (int endIndex = startIndex + 1; endIndex <= n; endIndex++) {
            // 看看哪些前缀存在 wordDict 中
            String prefix = s.substring(startIndex, endIndex);
            if (wordDict.contains(prefix)) {
                // 找到一个单词匹配 s[startIndex..endIndex)
                List<String> subQuestion = dp(s, endIndex);
                // 构成 s[endIndex..] 的所有组合加上 prefix
                // 就是构成构成 s[startIndex...] 的所有组合
                for (String sub : subQuestion) {
                    if (sub.isEmpty()) {
                        // 防止多余的空格
                        res.add(prefix);
                    } else {
                        res.add(prefix + " " + sub);
                    }
                }
            }
        }
        // 存入备忘录
        memo[startIndex] = res;
        return res;
    }
}
