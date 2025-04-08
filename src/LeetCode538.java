import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode538 {
}
class Solution538 {
    private int pre=0;
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }
    public void traversal(TreeNode root){
        if (root==null) return;
        traversal(root.right);
        root.val += pre;
        pre = root.val;
        traversal(root.left);
    }
}

class Solution538_iteration {
    //遍历顺序右中左
    public TreeNode convertBST(TreeNode root) {
        if (root==null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        int pre =0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            if (node!=null){
                if (node.left!=null) stack.offerLast(node.left);
                stack.offerLast(node);
                stack.offerLast(null);
                if (node.right!=null) stack.offerLast(node.right);
            }
            else {
                TreeNode node1 = stack.pollLast();
                node1.val += pre;
                pre = node1.val;
            }
        }
        return root;
    }
}