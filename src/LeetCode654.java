public class LeetCode654 {
}
class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursion(nums,0,nums.length);
    }
    //左开右闭
    public TreeNode recursion(int[] nums,int leftIndex,int rightIndex){
        if (rightIndex-leftIndex==0){
            return null;
        }
        if (rightIndex-leftIndex ==1){
            return new TreeNode(nums[leftIndex]);
        }
        int maxValue = nums[leftIndex];
        int maxIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i]>maxValue){
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode node = new TreeNode(maxValue);
        node.left = recursion(nums,leftIndex,maxIndex);
        node.right = recursion(nums,maxIndex+1,rightIndex);
        return node;
    }
}