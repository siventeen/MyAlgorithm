public class LeetCode235 {
}
class Solution235_recursion {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        if (root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        else {
            return root;
        }
    }
}

class Solution235_iteration {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val>p.val&&root.val>q.val){
                root = root.left;
            }
            else if (root.val<p.val&&root.val< q.val){
                root = root.right;
            }
            else {
                return root;
            }
        }
    }
}