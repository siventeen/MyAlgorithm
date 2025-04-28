import java.util.LinkedList;

public class LeetCode1849 {
    // 站在子串的视角进行穷举
    public boolean splitString(String s) {
        backtrack(s, 0);
        return found;
    }

    LinkedList<String> track = new LinkedList<>();
    boolean found = false;

    void backtrack(String s, int start) {
        if (found) {
            // 剪枝，找到一个答案后就不要再继续回溯了
            return;
        }
        if (start == s.length()) {
            if (track.size() >= 2 && String.join("", track).equals(s)) {
                found = true;
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1);
            int leadingZeroCount = 0;
            for (int j = 0; j < subStr.length(); j++) {
                if (subStr.charAt(j) == '0') {
                    leadingZeroCount++;
                } else {
                    break;
                }
            }
            if (subStr.length() - leadingZeroCount > (s.length() + 1) / 2) {
                // 剪枝逻辑，如果当前截取的子串长度大于 s 的一半，那么没必要继续截取了，肯定不可能只差一
                // 同时可以避免溢出 long 的最大值的问题
                return;
            }

            long curNum = Long.parseLong(subStr);
            if (track.isEmpty() || Long.parseLong(track.getLast()) - curNum == 1) {
                // 符合题目的要求，当前数字比上一个数字小 1
                // 做选择，切割出一个子串
                track.add(subStr);
                backtrack(s, i + 1);
                // 撤销选择
                track.removeLast();
            }
        }
    }


    // 站在字符的视角进行穷举
    class Solution1849_2 {
        public boolean splitString(String s) {
            backtrack(s, 0, 0);
            return found;
        }

        LinkedList<String> track = new LinkedList<>();
        boolean found = false;

        void backtrack(String s, int start, int index) {
            if (found) {
                // 剪枝，找到一个答案后就不要再继续回溯了
                return;
            }
            if (index == s.length()) {
                if (track.size() >= 2 && String.join("", track).equals(s)) {
                    found = true;
                }
                return;
            }

            // 选择一，s[index] 决定切割
            String subStr = s.substring(start, index + 1);
            int leadingZeroCount = 0;
            for (int j = 0; j < subStr.length(); j++) {
                if (subStr.charAt(j) == '0') {
                    leadingZeroCount++;
                } else {
                    break;
                }
            }
            if (subStr.length() - leadingZeroCount > (s.length() + 1) / 2) {
                // 剪枝逻辑，如果当前截取的子串长度大于 s 的一半，那么没必要继续截取了，肯定不可能只差一
                // 同时可以避免溢出 long 的最大值的问题
                return;
            }
            long curNum = Long.parseLong(subStr);
            if (track.isEmpty() || Long.parseLong(track.getLast()) - curNum == 1) {
                // 符合题目的要求，当前数字比上一个数字小 1
                // 做选择，切割出一个子串
                track.add(subStr);
                backtrack(s, index + 1, index + 1);
                // 撤销选择
                track.removeLast();
            }

            // 选择二，s[index] 决定不切割
            backtrack(s, start, index + 1);
        }
    }
}
