import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public static String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        String res = "";
        StringBuilder stringBuilder = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int leftIndex = 0, rightIndex = 0;
        int matchNum = 0;
        while (rightIndex < sLen && matchNum < tLen){
            char c = s.charAt(rightIndex);
            stringBuilder.append(c);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    matchNum++;
                }
                map.put(c, map.get(c) - 1);
            }
            rightIndex++;
        }
        if (matchNum < tLen) {
            return res;
        }
        while (leftIndex < rightIndex && (!map.containsKey(s.charAt(leftIndex)) || map.get(s.charAt(leftIndex)) < 0)) {
            if (map.containsKey(s.charAt(leftIndex)) && map.get(s.charAt(leftIndex)) < 0) {
                map.put(s.charAt(leftIndex), map.get(s.charAt(leftIndex)) + 1);
            }
            stringBuilder.deleteCharAt(0);
            leftIndex++;
        }
        minLen = stringBuilder.length();
        res = stringBuilder.toString();
        while (rightIndex < sLen) {
            char c = s.charAt(rightIndex);
            stringBuilder.append(c);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            while (leftIndex < rightIndex && (!map.containsKey(s.charAt(leftIndex)) || map.get(s.charAt(leftIndex)) < 0)) {
                if (map.containsKey(s.charAt(leftIndex)) && map.get(s.charAt(leftIndex)) < 0) {
                    map.put(s.charAt(leftIndex), map.get(s.charAt(leftIndex)) + 1);
                }
                stringBuilder.deleteCharAt(0);
                leftIndex++;
            }

            if (stringBuilder.length() < minLen) {
                minLen = stringBuilder.length();
                res = stringBuilder.toString();
            }
            rightIndex++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }
}
