public class LeetCode110 {
}
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        //使用-1来标记root不是平衡二叉树,
        return getDepth(root) != -1;
    }

    //如果root不是平衡二叉树则返回-1，否则返回二叉树的高度。
    public int getDepth(TreeNode root){
        if (root==null) return 0;
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) return -1;
        int rightDept = getDepth(root.right);
        if (rightDept == -1) return -1;

        return Math.abs(leftDepth-rightDept)>1 ? -1 : Math.max(leftDepth,rightDept)+1;
    }
}