public class LeetCode11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int result = 0;
        int left = 0, right = len - 1;
        while (left < right) {
            int nowArea = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(nowArea, result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
