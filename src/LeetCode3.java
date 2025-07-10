import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 1;
        int result = 1;
        set.add(s.charAt(0));
        while (right < len) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(c);
                left++;
            }
            set.add(c);
            result = Math.max(result, set.size());
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("pwwkew");
    }
}
