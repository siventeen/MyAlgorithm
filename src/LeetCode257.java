import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LeetCode257 {
}
class Solution257_traverse {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null)
            return res;
        traverse(root,path,res);
        return res;
    }
    public void traverse(TreeNode root,List<Integer> path,List<String> res){
        path.add(root.val);
        //叶子结点
        if (root.left==null && root.right==null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
        }

        if (root.left!=null){
            traverse(root.left,path,res);//递归
            path.remove(path.size()-1);//回溯
        }
        if (root.right!=null){
            traverse(root.right,path,res);//递归
            path.remove(path.size()-1);//回溯
        }
    }
}

class Solution257_iteration {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Deque<TreeNode> treeSt = new LinkedList<>();
        Deque<String> pathSt = new LinkedList<>();
        //root为空直接返回
        if (root == null)
            return res;
        //树节点和path路径各自进栈
        treeSt.offerLast(root);
        pathSt.offerLast(root.val+"");
        //当树节点不为空时进行迭代，treeSt和pathSt的size是一致的
        while (!treeSt.isEmpty()){
            //node和path分别出栈
            TreeNode node = treeSt.pollLast();
            String path = pathSt.pollLast();

            //叶子结点时，路径加入res
            if (node.left==null&&node.right==null){
                res.add(path);
            }
            //若左节点不为空，则左节点进栈，并且path进栈
            if (node.left!= null){
                treeSt.offerLast(node.left);
                pathSt.offerLast(path+"->"+node.left.val);
            }
            if (node.right!= null){
                treeSt.offerLast(node.right);
                pathSt.offerLast(path+"->"+node.right.val);
            }

        }

        return res;
    }

}