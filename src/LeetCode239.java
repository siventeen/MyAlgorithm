import java.util.Deque;
import java.util.LinkedList;

public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        // 存储滑动窗口内单调递减元素的下标值
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
