import java.util.Deque;
import java.util.LinkedList;

public class LeetCode117 {
}
class Solution117 {

    public Node1 connect(Node1 root) {
        if (root == null){
            return null;
        }
        Deque<Node1> deque = new LinkedList<>();
        Node1 preNode = null;
        deque.offerLast(root);
        while (!deque.isEmpty()){
            //取出每一层的第一个节点
            preNode = deque.pollFirst();
            //在把第一个节点的子节点放进队列前，记录当前层的剩余节点数
            int size = deque.size();
            //把第一个节点的左右子节点放进队列
            if (preNode.left!=null) deque.offerLast(preNode.left);
            if (preNode.right!=null) deque.offerLast(preNode.right);

            while (size>0){
                size--;
                //依次让当前层的前一个节点的next指针指向当前节点，并把curNode设置为下一次循环中的preNode
                Node1 curNode = deque.pollFirst();
                preNode.next = curNode;
                preNode = curNode;
                if (curNode.left != null){
                    deque.offerLast(curNode.left);
                }
                if (curNode.right != null){
                    deque.offerLast(curNode.right);
                }

            }
        }
        return root;
    }
}
