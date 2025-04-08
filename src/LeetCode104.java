import java.util.Deque;
import java.util.LinkedList;

public class LeetCode104 {
}
class Solution104_deepth {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }
}

class Solution104_breadth {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int res=0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            res++;
            int size = deque.size();
            while (size>0){
                size--;
                TreeNode node = deque.pollFirst();
                if (node.left!=null) deque.offerLast(node.left);
                if (node.right!=null) deque.offerLast(node.right);
            }
        }
        return res;
    }
}

