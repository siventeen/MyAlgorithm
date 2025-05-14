import java.util.*;

public class LeetCode863 {
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();

        traverse(root, null);
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target.val);

        int distance = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                if (distance == k) {
                    res.add(cur.val);
                }

                TreeNode parentNode = parentMap.get(cur.val);
                if (parentNode != null && !visited.contains(parentNode.val)) {
                    queue.offer(parentNode);
                    visited.add(parentNode.val);
                }

                if (cur.left != null && !visited.contains(cur.left.val)) {
                    queue.offer(cur.left);
                    visited.add(cur.left.val);
                }
                if (cur.right != null && !visited.contains(cur.right.val)) {
                    queue.offer(cur.right);
                    visited.add(cur.right.val);
                }
            }
            distance++;
            if (distance > k) {
                break;
            }
        }
        return res;
    }


    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }
        parentMap.put(root.val, parentNode);
        // 二叉树递归框架
        traverse(root.left, root);
        traverse(root.right, root);
    }
}
