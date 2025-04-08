import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeedCode572 {
}
//暴力解法
class Solution572_recursion {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root==null) return false;

        if (isSameTree(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot ==null) return true;
        if (root ==null || subRoot == null || root.val != subRoot.val) return false;

        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
}


//深度优先搜索序列上做串匹配
//思路：如果subRoot的前序遍历序列是root先序遍历序列的子序列，那么subRoot就很可能是root的子树，
// 但是先序遍历的顺序是中左右，所以如果先序遍历顺序是（1,2）的话，如法判断2是1的左孩子还是右孩子
// 所以，如想要这个条件成立需要在先序遍历的序列中加入左右空节点。
// 然后判断subRoot的前序遍历序列是否root先序遍历序列的子序列
class Solution572_KMP {
    //我们用整数的list来保存两棵树的前序遍历序列，用Integer.MAX_VALUE来标记空节点的值。
    int  NullVal = Integer.MAX_VALUE;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<Integer> sOrder = new ArrayList<Integer>();
        List<Integer> tOrder = new ArrayList<Integer>();

        //先用递归获取先序遍历的序列
        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        //然后用KMP算法判断tOrder是否是sOrder的子序列
        return kmp(sOrder,tOrder);
    }


    public void getDfsOrder(TreeNode t, List<Integer> tar) {
        if (t == null) {
            return;
        }
        tar.add(t.val);
        if (t.left != null) {
            getDfsOrder(t.left, tar);
        } else {
            tar.add(NullVal);
        }
        if (t.right != null) {
            getDfsOrder(t.right, tar);
        } else {
            tar.add(NullVal);
        }
    }
    public boolean kmp(List<Integer> sOrder,List<Integer> tOrder) {
        //字符串aabaabaaf
        //模式串aabaaf

        int sLen = sOrder.size(), tLen = tOrder.size();
        //tOrder的前缀表
        int[] next = new int[tOrder.size()];
        for (int i = 1, j = 0; i < tLen; ++i) {
            while (j > 0 && !(tOrder.get(i).equals(tOrder.get(j)))) {
                j = next[j-1];
            }
            if (tOrder.get(i).equals(tOrder.get(j))) {
                ++j;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < sLen; ++i) {
            while (j > 0 && !(sOrder.get(i).equals(tOrder.get(j)))) {
                j = next[j-1];
            }
            if (sOrder.get(i).equals(tOrder.get(j))) {
                ++j;
            }
            if (j == tLen ) {
                return true;
            }
        }
        return false;
    }

//    public boolean kmp(List<Integer> sOrder,List<Integer> tOrder) {
//        int sLen = sOrder.size(), tLen = tOrder.size();
//        int[] fail = new int[tOrder.size()];
//        Arrays.fill(fail, -1);
//        for (int i = 1, j = -1; i < tLen; ++i) {
//            while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
//                j = fail[j];
//            }
//            if (tOrder.get(i).equals(tOrder.get(j + 1))) {
//                ++j;
//            }
//            fail[i] = j;
//        }
//        for (int i = 0, j = -1; i < sLen; ++i) {
//            while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
//                j = fail[j];
//            }
//            if (sOrder.get(i).equals(tOrder.get(j + 1))) {
//                ++j;
//            }
//            if (j == tLen - 1) {
//                return true;
//            }
//        }
//        return false;
//    }
}
