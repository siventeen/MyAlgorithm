import java.util.*;

public class LeetCode752 {

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        if (deads.contains("0000")) {
            return -1;
        }
        // 避免访问重复的字符串
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                List<String> neighbors = getNeighbors(cur);
                for (String neighbor : neighbors) {
                    if (!deads.contains(neighbor) && !visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> getNeighbors(String cur) {
        List<String> neighbors = new ArrayList<>();
        int size = cur.length();
        for (int i = 0; i < size; i++) {
            neighbors.add(goUp(cur, i));
            neighbors.add(goDown(cur, i));
        }
        return neighbors;
    }
    // 将 s[index] 向上拨动一次
    private String goUp(String s, int index) {
        char[] chars = s.toCharArray();
        if (s.charAt(index) == '9') {
            chars[index] = '0';
        } else {
            chars[index]++;
        }
        return new String(chars);
    }
    // 将 s[index] 向下拨动一次
    private String goDown(String s, int index) {
        char[] chars = s.toCharArray();
        if (s.charAt(index) == '0') {
            chars[index] = '9';
        } else {
            chars[index]--;
        }
        return new String(chars);
    }


}
