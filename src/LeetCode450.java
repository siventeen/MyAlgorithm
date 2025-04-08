public class LeetCode450 {
}
class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        //否则root的值就是要删除的key
        //如果root的左子树为空，返回右子树
        if (root.val == key){
            if (root.left == null){
                return root.right;
            }
            //如果root的右子树为空，返回左子树
            if (root.right == null){
                return root.left;
            }
            else {
                //如果左右子树都不为空，把左子树放在右子树最左边节点的左子树上。
                TreeNode left = root.left;
                TreeNode right = root.right;
                while (right.left!=null){
                    right = right.left;
                }
                right.left = left;
                return root.right;
            }
        }
        if (root.val> key){
            root.left = deleteNode(root.left,key);
        }
        if (root.val<key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}