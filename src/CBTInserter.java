import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    private TreeNode root;
    Queue<TreeNode> canInsertNodeQueue = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
            if (cur.left == null || cur.right == null) canInsertNodeQueue.offer(cur);
        }
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode topNode = canInsertNodeQueue.peek();
        if (topNode.left == null) {
            topNode.left = newNode;
            canInsertNodeQueue.offer(newNode);
        } else if (topNode.right == null) {
            topNode.right = newNode;
            canInsertNodeQueue.offer(newNode);
            canInsertNodeQueue.poll();
        }
        return topNode.val;
    }

    public TreeNode get_root() {
        return this.root;
    }




    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

