import java.util.*;

public class LeetCode433 {
    char[] genes = {'A', 'C', 'G', 'T'};
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int step = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String cur = queue.poll();
                if (cur.equals(endGene)) {
                    return step;
                }
                List<String> neighbors = getNeighbors(cur);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor) && bankSet.contains(neighbor)) {
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
        int len = cur.length();
        char[] oldChars = cur.toCharArray();
        for (int i = 0; i < len; i++) {
            char[] newChars = oldChars.clone();
            for (char gene : genes) {
                newChars[i] = gene;
                neighbors.add(new String(newChars));
            }
        }

        return neighbors;
    }
}
