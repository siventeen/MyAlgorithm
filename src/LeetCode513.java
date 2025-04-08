import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode513 {
}
class Solution513_recursion {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int num = deque.size();
            TreeNode node = deque.pollFirst();
            res = node.val;
            if (node.left!=null){
                deque.offerLast(node.left);
            }
            if (node.right!=null){
                deque.offerLast(node.right);
            }
            for (int i = 0; i < num-1; i++) {
                TreeNode node1 = deque.pollFirst();
                if (node1.left!=null){
                    deque.offerLast(node1.left);
                }
                if (node1.right!=null){
                    deque.offerLast(node1.right);
                }
            }
        }
        return res;
    }
}

class Solution513_iteration {
    public int res=0;
    public int maxDepth=0;
    public int findBottomLeftValue(TreeNode root) {
        findLeft(root,maxDepth);
        return res;
    }

    public void findLeft (TreeNode root, int depth){
        depth++;
        if (root.left==null && root.right==null){
            if (depth>maxDepth){
                maxDepth=depth;
                res = root.val;
            }
            return;
        }
        if (root.left!=null){
            findLeft(root.left,depth);
        }
        if (root.right!=null){
            findLeft(root.right,depth);
        }
    }
}