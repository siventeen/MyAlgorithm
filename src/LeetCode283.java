public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0;
        int fast = 1;
        while (fast < len) {
            if (nums[fast] != 0 && nums[slow] == 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
            }
            fast++;
            if (nums[slow] != 0) {
                slow++;
            }
        }
    }
}
