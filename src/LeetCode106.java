import java.util.ArrayList;
import java.util.List;

public class LeetCode106 {

}
class Solution106 {
    //保存先序遍历结果
    List<Integer> list = new ArrayList<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //中序区间：[inorderBegin, inorderEnd)，后序区间[postorderBegin, postorderEnd)
        TreeNode tree =  traversal(inorder,0,inorder.length,postorder,0,postorder.length);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return tree;
    }

    public TreeNode traversal(int[] inorder,int inorderBegin,int inorderEnd,int[] postorder,int postorderBegin,int postorderEnd){
        //返回空节点
        if (postorderBegin==postorderEnd) return null;

        //定义根节点
        int rootValue = postorder[postorderEnd-1];
        TreeNode rootNode = new TreeNode(rootValue);
        list.add(rootValue);
        //返回叶子结点
        if (postorderBegin == postorderEnd-1) {
            //list.add(rootValue); //将叶子节点的值添加到list
            return rootNode;
        }

        //根节点在中序遍历中的下标
        int inorderRootIndex = inorderBegin;
        for (; inorderRootIndex < inorderEnd; inorderRootIndex++) {
            if (inorder[inorderRootIndex] == rootValue) break;
        }

        //中序遍历左子树起始下标[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = inorderRootIndex;
        //中序遍历右子树起始下标[rightInorderBegin, rightInorderEnd
        int rightInorderBegin = inorderRootIndex+1;
        int rightInorderEnd = inorderEnd;

        //后序遍历左子树起始下标[leftPostorderBegin, leftPostorderEnd)
        int leftPostOrderBegin = postorderBegin;
        int leftPostOrderEnd = postorderBegin + inorderRootIndex - inorderBegin;
        //后序遍历右子树起始下标[rightPostorderBegin, rightPostorderEnd)
        int rightPostorderBegin = leftPostOrderEnd;
        int rightPostorderEnd = postorderEnd-1;

        rootNode.left = traversal(inorder,leftInorderBegin,leftInorderEnd,postorder,leftPostOrderBegin,leftPostOrderEnd);
        rootNode.right = traversal(inorder,rightInorderBegin,rightInorderEnd,postorder,rightPostorderBegin,rightPostorderEnd);
        //list.add(rootValue);//将非叶子节点的值添加到list
        return rootNode;
    }
}