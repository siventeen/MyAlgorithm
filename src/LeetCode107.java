import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode107 {

}
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            while (size>0){
                size--;
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if (node.left!= null) deque.offerLast(node.left);
                if (node.right!= null) deque.offerLast(node.right);
            }
            result.add(0,list);
        }
        return result;
    }
}