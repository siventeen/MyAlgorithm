import java.util.LinkedList;
import java.util.Queue;

public class LeetCode662 {
    public static class NodeCodePair {
        public TreeNode node;
        public int code;
        public NodeCodePair(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<NodeCodePair> queue = new LinkedList<>();
        queue.offer(new NodeCodePair(root, 1));
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int left = 0, right = 0;
            for (int i = 0; i < queueSize; i++) {
                NodeCodePair nodeCodePair = queue.poll();
                if (i == 0) {
                    left = nodeCodePair.code;
                }
                if (i == queueSize - 1) {
                    right = nodeCodePair.code;
                }

                if (nodeCodePair.node.left != null) {
                    queue.offer(new NodeCodePair(nodeCodePair.node.left, nodeCodePair.code * 2));
                }
                if (nodeCodePair.node.right != null) {
                    queue.offer(new NodeCodePair(nodeCodePair.node.right, nodeCodePair.code * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);

        }

        return maxWidth;
    }
}
