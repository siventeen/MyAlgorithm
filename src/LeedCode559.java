import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeedCode559 {
}
//深度优先，递归
class Solution_559_depth {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        else if (root.children == null || root.children.size()==0){
            return 1;
        }
        int childMaxDepth = -1;
        List<Node> child = root.children;
        int size = child.size();
        for (int i = 0; i < size; i++) {
            Node node = root.children.get(i);
            childMaxDepth = Math.max(childMaxDepth,maxDepth(node));
        }
        return childMaxDepth+1;
    }
}

//广度优先，迭代
class Solution_559_breadth {
    public int maxDepth(Node root) {
        if (root==null) return 0;
        int depth = 0;
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            while (size>0){
                size--;
                Node rootNode = queue.pollFirst();
                assert rootNode != null;
                if (rootNode.children==null || rootNode.children.size()==0){
                    continue;
                }
                List<Node> child = rootNode.children;
                for (Node node : child) {
                    queue.offerLast(node);
                }
            }
        }
        return depth;
    }
}
