import java.util.Arrays;
import java.util.HashMap;

// 以数字的视角选择桶
public class LeetCode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        // k 个桶（集合），记录每个桶装的数字之和
        int target = sum / k;
        // 理论上每个桶（集合）中数字的和
        int[] bucket = new int[k];
        // 降序排序 nums 数组
        Arrays.sort(nums);
        return backTrack(nums, bucket, 0, target);
    }

    private boolean backTrack(int[] nums, int[] bucket, int index, int target) {
        if (index == nums.length) {
            // nums 成功平分成 k 个子集
            return true;
        }
        // 穷举 nums[index] 可能装入的桶
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝，桶装装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            // 如果当前桶和上一个桶内的元素和相等，则跳过
            // 原因：如果元素和相等，那么 nums[index] 选择上一个桶和选择当前桶可以得到的结果是一致的
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;

            // 对于第一个球，任意放到某个桶中的效果都是一样的，所以我们规定放到第一个桶中
            if (i > 0 && index == 0) break ;

            // 将 nums[index] 装入 bucket[i]
            bucket[i] += nums[index];
            // 递归穷举下一个数字的选择
            if (backTrack(nums, bucket, index + 1, target)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }
        // nums[index] 装入哪个桶都不行
        return false;
    }
}

// 以桶的视角选择数字
class Solution698_2 {
    HashMap<Integer, Boolean> memo = new HashMap<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        // 使用位图技巧
        int used = 0;
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }
    boolean backtrack(int k, int bucket,
                      int[] nums, int start, int used, int target) {
        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            // 缓存结果
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }

        for (int i = start; i < nums.length; i++) {
            // 剪枝
            // 判断第 i 位是否是 1
            if (((used >> i) & 1) == 1) {
                // nums[i] 已经被装入别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择
            // 将第 i 位置为 1
            used |= 1 << i;
            bucket += nums[i];
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            // 使用异或运算将第 i 位恢复 0
            used ^= 1 << i;
            bucket -= nums[i];
        }

        return false;
    }
}
