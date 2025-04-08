import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.annotation.Target;

public class LeetCode112 {
}
class Solution112_recursion {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        return recursion(root,0,targetSum);
    }
    public boolean recursion(TreeNode root, int sum,int targetSum){
        sum += root.val;
        if (root.left == null && root.right ==null){
            if (sum == targetSum){
                return true;
            }else {
                return false;
            }
        }

        if (root.left!=null){
            boolean leftBoolean = recursion( root.left,sum,targetSum);
            if (leftBoolean){
                return true;
            }
        }
        if (root.right!=null){
            boolean rightBoolean = recursion( root.right,sum,targetSum);
            if (rightBoolean){
                return true;
            }
        }
        return false;
    }
}
