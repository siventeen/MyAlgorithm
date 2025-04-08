import java.util.Deque;
import java.util.LinkedList;

public class LeetCode404 {

}
class Solution404_traverse {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null)
            return 0;
        int mid = 0;
        if (root.left!=null && root.left.left==null && root.left.right==null){
            mid = root.left.val;
        }
        return mid + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

class Solution404_iteration {
    public int sumOfLeftLeaves(TreeNode root) {
        int res =0;
        if (root==null)
            return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            if (node.left!=null && node.left.left==null&&node.left.right==null){
                res+=node.left.val;
            }
            if (node.left!=null) stack.offerLast(node.left);
            if (node.right!=null) stack.offerLast(node.right);
        }
        return res;
    }
}