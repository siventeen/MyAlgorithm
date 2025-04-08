import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode199 {
}
class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int Size = que.size();

            for (int i = 0; i < Size; i++) {
                TreeNode node = que.pollFirst();

                if (node.left != null) que.addLast(node.left);
                if (node.right != null) que.addLast(node.right);

                if (i == Size - 1) list.add(node.val);
            }
        }

        return list;
    }
}