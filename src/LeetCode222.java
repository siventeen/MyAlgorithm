public class LeetCode222 {
}

class Solution222_depth {
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum+rightNum+1;
    }
}

class Solution222_xingzhi {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth){
            //如果左子树和右子树的深度相等，说明左子树是满二叉树，左子树节点个数为2^leftDepth-1,
            //所以应该返回左子树节点个数+1（根节点）+右子树节点个数
            return (1<<leftDepth) + countNodes(root.right);
        }
        else {
            //如果左子树和右子树的深度相等，说明左子树是满二叉树，左子树节点个数为2^rightDepth-1,
            return (1<<rightDepth) + countNodes(root.left);
        }

    }

    public int getDepth(TreeNode treeNode){
        int depth = 0;
        while (treeNode != null){
            depth++;
            //因为是完全二叉树，所以遍历left子节点就能得到深度。
            treeNode = treeNode.left;
        }
        return depth;
    }
}