import java.util.ArrayList;
import java.util.List;

public class LeetCode105 {

}
class Solution105 {
    //保存后序遍历结果
    public static List<Integer> list = new ArrayList<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode tree = traversal(preorder,0,preorder.length,inorder,0,inorder.length);
        //输出后序遍历结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return tree;
    }

    public TreeNode traversal(int[] preorder,int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inorderEnd){
        //返回空节点
        if (preorderBegin == preorderEnd) return null;
        //获取根节点值
        int rootValue = preorder[preorderBegin];
        TreeNode treeNode = new TreeNode(rootValue);
        if (preorderEnd-preorderBegin == 1) {
            list.add(rootValue);
            return treeNode;
        }

        int inorderRootIndex=inorderBegin;
        for (; inorderRootIndex < inorderEnd; inorderRootIndex++) {
            if (inorder[inorderRootIndex] == rootValue) break;;
        }

        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = inorderRootIndex;
        int rightInorderBegin = inorderRootIndex+1;
        int rightInorderEnd = inorderEnd;

        int leftPreorderBegin = preorderBegin+1;
        int leftPreorderEnd = preorderBegin+1+inorderRootIndex-inorderBegin;
        int rightPreorderBegin = leftPreorderEnd;
        int rightPreorderEnd = preorderEnd;

        treeNode.left = traversal(preorder,leftPreorderBegin,leftPreorderEnd,inorder,leftInorderBegin,leftInorderEnd);
        treeNode.right = traversal(preorder,rightPreorderBegin,rightPreorderEnd,inorder,rightInorderBegin,rightInorderEnd);
        list.add(rootValue);
        return treeNode;
    }
}
