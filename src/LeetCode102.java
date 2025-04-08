import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode102 {
}
class Solution102 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return result;
        deque.addLast(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            while (size>0){
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
                size--;
            }
            result.add(list);
        }
        return result;
    }
}
