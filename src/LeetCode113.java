import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
}
class Solution113_recursion {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return result;
        }
        recursion(root,0,targetSum,list);
        return result;
    }
    public void recursion(TreeNode root,int sum,int targetSum,List<Integer> list){
        sum = sum+root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if (sum == targetSum){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if (root.left!=null){
            recursion(root.left,sum,targetSum,list);
            list.remove(list.size()-1);
        }
        if (root.right!=null){
            recursion(root.right,sum,targetSum,list);
            list.remove(list.size()-1);
        }
    }
}