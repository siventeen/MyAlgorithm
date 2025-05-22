import java.util.*;

public class LeetCode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<Integer>> emailToIndexes = new HashMap<>();
        for (int i= 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                List<Integer> indexes = emailToIndexes.getOrDefault(email, new ArrayList<>());
                indexes.add(i);
                emailToIndexes.put(email, indexes);
            }
        }
        // 计算合并后的账户
        List<List<String>> res = new ArrayList<>();
        HashSet<String> visitedEmails = new HashSet<>();

        for (String email : emailToIndexes.keySet()) {
            if (visitedEmails.contains(email)) {
                continue;
            }
            // 合并账户，用 BFS 算法穷举所有和 email 相关联的邮箱
            LinkedList<String> mergedEmail = new LinkedList<>();
            Queue<String> q = new LinkedList<>();
            q.offer(email);
            visitedEmails.add(email);
            // BFS 算法框架
            while (!q.isEmpty()) {
                String curEmail = q.poll();
                mergedEmail.addLast(curEmail);
                List<Integer> indexes = emailToIndexes.get(curEmail);
                for (int index : indexes) {
                    List<String> account = accounts.get(index);
                    for (int j = 1; j < account.size(); j++) {
                        String nextEmail = account.get(j);
                        if (!visitedEmails.contains(nextEmail)) {
                            q.offer(nextEmail);
                            visitedEmails.add(nextEmail);
                        }
                    }
                }
            }
            String userName = accounts.get(emailToIndexes.get(email).get(0)).get(0);
            // mergedEmail 是 userName 的所有邮箱
            Collections.sort(mergedEmail);
            mergedEmail.addFirst(userName);
            res.add(mergedEmail);
        }
        return res;
    }
}
