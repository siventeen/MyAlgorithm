import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class LeetCode98 {
}
class Solution98_recursion {
    public boolean isValidBST(TreeNode root) {
        return Valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean Valid(TreeNode root,long left,long right){
        if (root == null) return true;
        if (root.val<= left || root.val >=right) return false;

        boolean leftBool = Valid(root.left,left,root.val);
        boolean rightBool = Valid(root.right,root.val,right);
        return leftBool && rightBool;
    }
}

class Solution98_recursion2 {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        int size = list.size();
        for (int i = 0; i < size-1; i++) {
            if (list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void traversal(TreeNode root){
        if (root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}

class Solution98_recursion3 {
    // 递归
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }
}

class Solution98_iteration {
    // 迭代
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            root = pop.right;// 右
        }
        return true;
    }
}