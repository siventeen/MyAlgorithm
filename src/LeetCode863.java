import java.util.*;

public class LeetCode863 {
    // 记录父节点：node.val -> parentNode
    // 题目说了树中所有节点值都是唯一的，所以可以用 node.val 代表 TreeNode
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        // 遍历所有节点，记录每个节点的父节点
        traverse(root, null);
        // 开始从 target 节点施放 BFS 算法，找到距离为 k 的节点
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target.val);
        // 记录离 target 的距离
        int distance = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                if (distance == k) {
                    // 找到距离起点 target 距离为 k 的节点
                    res.add(cur.val);
                }

                // 向父节点、左右子节点扩散
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
            // 向外扩展一圈
            distance++;
            // 当距离大于k时不必再遍历
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
