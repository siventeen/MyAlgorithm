public class LeetCode75 {
    public void sortColors(int[] nums) {
        int[] counter = new int[3];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            counter[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < counter[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
