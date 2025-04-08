import java.util.Deque;
import java.util.LinkedList;

public class LeetCode111 {
}

class Solution111_depth {
    public int minDepth(TreeNode root) {
        //如果根节点为null就返回0
        if (root == null) return 0;
        //否则计算其左右子节点的深度
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //如果左子节点的深度为0，则返回其右子节点的深度加1
        if (left==0) return right+1;
        //如果右子节点的深度为0，则返回其左子节点的深度加1
        if (right == 0) return left+1;
        //否则返回他们的最小值加1
        else return Math.min(left,right)+1;
    }
}

class Solution111_breadth {
    public int minDepth(TreeNode root) {
        //如果根节点为null就返回0
        if (root == null) return 0;

        Deque<TreeNode> deque = new LinkedList<>();
        //先把root节点放进队列里面
        deque.offerLast(root);
        int result=0;
        while (!deque.isEmpty()){
            int size = deque.size();
            //没遍历一层深度就加1
            result++;
            while (size>0){
                size--;
                TreeNode node = deque.pollFirst();
                //当第一次遍历到左右子节点都为null的节点的时候就直接返回深度result。
                if (node.left==null&&node.right==null) return result;
                else {
                    if (node.left!=null) deque.offerLast(node.left);
                    if (node.right!=null) deque.offerLast(node.right);
                }
            }
        }
        return result;
    }
}