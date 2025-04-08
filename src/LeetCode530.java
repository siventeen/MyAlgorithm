public class LeetCode530 {
}
class Solution530_recursion {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        minDiff(root);
        return result;
    }

    public void minDiff(TreeNode root){
        if (root == null) return;
        minDiff(root.left);
        if (pre!=null && root.val-pre.val<result) result = root.val-pre.val;
        pre = root;
        minDiff(root.right);
    }
}