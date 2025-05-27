import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    // 备忘录， memo[i]=-1表示memo[i...]没有被计算，memo[i]=0表示memo[i...]无法被凑出，memo[i]=1表示memo[i...]可以被凑出
    int[] memo;
    // 字典单词的集合，用于判断字符串的前缀是否包含在字典单词里
    Set<String> wordSet = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        wordSet.addAll(wordDict);
        return dp(s, 0);
    }

    private boolean dp(String s, int startIndex) {
        // 终止条件，字符串被匹配完了，说明可以通过字典拼接出s
        if (startIndex == s.length()) {
            return true;
        }

        // 避免重复计算
        if (memo[startIndex] != -1) {
            return memo[startIndex] != 0;
        }
        // 遍历 s[startIndex..] 的所有前缀
        for (int endIndex = startIndex; endIndex <= s.length(); endIndex++) {
            String prefix = s.substring(startIndex, endIndex);
            // 找到一个匹配的子串
            if (wordSet.contains(prefix)) {
                // 看子问题是否能被匹配
                boolean subSolution = dp(s, endIndex);
                if (subSolution) {
                    // 可以匹配，存入备忘录，返回结果
                    memo[startIndex] = 1;
                    return true;
                }
            }
        }
        // 没有可以匹配的子串，存入备忘录，返回结果
        memo[startIndex] = 0;
        return false;
    }
}
