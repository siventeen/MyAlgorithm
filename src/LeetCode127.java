import java.util.*;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将 wordList 转换为 HashSet，加速查找
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 直接套用 BFS 算法框架
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; ++i) {
                // 穷举 curWord 修改一个字符能得到的单词
                // 即对每个字符，穷举 26 个字母
                String curWord = q.poll();
                char[] chars = curWord.toCharArray();
                // 开始穷举每一位字符 curWord[j]
                for (int j = 0; j < curWord.length(); ++j) {
                    char originChar = chars[j];
                    // 对每一位穷举 26 个字母
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == originChar) continue;
                        chars[j] = c;
                        // 如果构成的新单词在 wordSet 中，就是找到了一个可行的下一步
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            }
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    // 最后别忘了把 curWord[j] 恢复
                    chars[j] = originChar;
                }
            }
            // 这里增加步数
            ++step;
        }
        return 0;
    }
}
