public class LeetCode42 {
    public static int trap(int[] height) {
        int result = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        while ( left < right && (height[left] == 0 || height[left] <= height[left + 1])) {
            left++;
        }
        while (left < right && (height[right] == 0 || height[right] <= height[right - 1])) {
            right--;
        }

        while (left < right) {
            int curHeight = Math.min(height[left], height[right]);
            int curLeft = left;
            int curRight = right;
            if (height[left] < height[right]) {
                while (left < right && height[curLeft] >= height[left]) {
                    result += (curHeight - height[left]);
                    left++;
                }
            } else {
                while (left < right && height[curRight] >= height[right]) {
                    result += (curHeight - height[right]);
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] h = new int[]{0};
        int res = trap(h);
    }
}
