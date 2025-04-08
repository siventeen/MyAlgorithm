import com.sun.xml.internal.bind.v2.schemagen.xmlschema.NoFixedFacet;

public class LeetCode701 {
}
class Solution701_recursion1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val>root.val) root.right = insertIntoBST(root.right,val);
        if (val<root.val) root.left = insertIntoBST(root.left,val);

        return root;
    }
}


class Solution701_recursion2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)return new TreeNode(val);
        insert(root,val);
        return root;
    }

    public void insert(TreeNode root,int val){
        if (root.val >val){
            if (root.left!=null){
                insertIntoBST(root.left,val);
            }
            else {
                TreeNode node = new TreeNode(val);
                root.left = node;
            }
        }
        else {
            if (root.right!=null){
                insertIntoBST(root.right,val);
            }
            else {
                TreeNode node = new TreeNode(val);
                root.right = node;
            }
        }
    }
}

class Solution701_iteration {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        TreeNode pre = null;
        while (node!=null){
            pre = node;
            if (node.val>val){
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        if (pre.val>val){
            pre.left = new TreeNode(val);
        }
        else {
            pre.right = new TreeNode(val);
        }

        return root;
    }
}