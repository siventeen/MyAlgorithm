import java.security.interfaces.RSAKey;
import java.util.*;

public class LeetCode144_145_94 {

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//递归iteration
//先序遍历
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

}

//递归iteration
//后续遍历
class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postorder(root,list);
        return list;
    }

    public void postorder (TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }
}

//递归iteration
//中序遍历
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root,list);
        return list;
    }

    public void inorder (TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}

//迭代recursion
//先序遍历
class Solution144_recursion {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root==null) {
            return result;
        }
        TreeNode node = root;
        while (node !=null || !stack.isEmpty()){
            while (node!=null){
                result.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node = stack.poll();
            node = node.right;

        }
        return result;
    }
}

class Solution144_recursion2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root==null) {
            return result;
        }
        stack.push(root);
        TreeNode node = null;
        while (!stack.isEmpty()){
            node = stack.poll();
            if (node!=null){
                if (node.right!=null) stack.push(node.right);
                if (node.left!=null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
            }else {
                node = stack.poll();
                result.add(node.val);
            }
        }
        return result;
    }
}


//递归recursion
//后续遍历
class Solution145_recursion {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root==null){
            return result;
        }
        TreeNode node = root;
        TreeNode pre = null;
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right==null || node.right==pre){
                result.add(node.val);
                pre = node;
                stack.pop();
                node = null;
            }else {
                node = node.right;
            }
        }
        return result;
    }
}
class Solution145_recursion2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root==null){
            return result;
        }
        TreeNode node = root;
        stack.push(root);
        while (!stack.isEmpty()){
            node = stack.poll();
            if(node!=null){
                stack.push(node);
                stack.push(null);
                if (node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }else {
                node = stack.poll();
                result.add(node.val);
            }
        }
        return result;
    }
}

//迭代recursion
//中序遍历
class Solution94_recursion {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root==null){
            return result;
        }
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            node = stack.poll();
            result.add(node.val);
            node = node.right;

        }
        return result;
    }
}

class Solution94_recursion2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root==null){
            return result;
        }
        stack.push(root);
        TreeNode node = null;
        while (!stack.isEmpty()){
            node = stack.poll();
            if (node!=null){
                if (node.right!=null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left!=null) stack.push(node.left);
            }else {
                node = stack.poll();
                result.add(node.val);
            }
        }
        return result;
    }
}


