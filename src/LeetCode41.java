import com.sun.imageio.plugins.gif.GIFImageReader;

public class LeetCode41 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int a = firstMissingPositive(nums);
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //判断nums[i]-1的位置存的数字是否正确，不正确的话就和i位置上的数字交换；不能直接判断i位置的数字是否正确，否则有重复数字的时候会死循环。
            while (nums[i]>0 && nums[i]<=n && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return n+1;
    }
}
