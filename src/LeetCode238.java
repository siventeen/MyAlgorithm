public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[length - 1] = nums[length - 1];
        for (int i = length - 2; i > 0; i--) {
            result[i] = result[i + 1] * nums[i];
        }
        int left = 1;
        for (int i = 0; i < length - 1; i++) {
            result[i] = left * result[i + 1];
            left *= nums[i];
        }
        result[length - 1] = left;
        return result;
    }
}
