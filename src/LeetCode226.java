import java.util.Deque;
import java.util.LinkedList;

public class LeetCode226 {
}
class Solution266_depth {
    public TreeNode invertTree(TreeNode root) {
        //递归终止条件，当root为null时返回null
        if (root == null) return null;
        //将当前节点的左右节点交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //左右子节点调用递归
        invertTree(root.left);
        invertTree(root.right);
        //返回翻转后的二叉树。
        return root;
    }
}
class Solution266_breadth {
    public TreeNode invertTree(TreeNode root) {
        //当root为null时返回null
        if (root == null) return null;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()){
            int size = deque.size();
            while (size>0){
                size--;
                TreeNode node = deque.pollFirst();
                swap(node);
                if (node.left!=null) deque.offerLast(node.left);
                if (node.right!=null) deque.offerLast(node.right);
            }
        }
        //返回翻转后的二叉树。
        return root;
    }
    public void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}