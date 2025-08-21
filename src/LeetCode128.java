import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longestLen = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curNum = n;
                int curLen = 1;
                while (set.contains(++curNum)) {
                    curLen++;
                }
                longestLen = Math.max(longestLen, curLen);
            }
        }
        return longestLen;
    }
}
