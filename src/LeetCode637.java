import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode637 {
}
class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return result;
        deque.addLast(root);
        //每一次while对应一层的节点。
        while (!deque.isEmpty()){
            //某一层节点的和
            double sum = 0.0d;
            int size = deque.size();
            int count = size;//某一层节点的数量
            while (size>0){
                TreeNode node = deque.pollFirst();
                sum+=node.val;
                if (node.left!=null) deque.addLast(node.left);
                if (node.right!=null) deque.addLast(node.right);
                size--;
            }
            result.add(sum/count);//将均值添加到结果里
        }
        return result;
    }
}
