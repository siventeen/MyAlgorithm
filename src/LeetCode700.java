public class LeetCode700 {
}
class Solution700_recursion {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null || root.val == val) return root;

        if (root.val>val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }
}

class Solution700_iteration {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if (root.val == val) return root;
            if (root.val > val) root = root.left;
            else root = root.right;
        }
        return null;
    }
}