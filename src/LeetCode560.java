import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // numMap记录前缀和的个数
        Map<Integer, Integer> numMap = new HashMap<>();
        numMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (numMap.containsKey(sum - k)) {
                count += numMap.get(sum - k);
            }
            numMap.put(sum, numMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
