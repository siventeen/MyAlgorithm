public class LeetCode486 {
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        // dp[i][j].fir 表示nums[i...j]先手能获得的最高分。dp[i][j].sec 表示nums[i...j]后手能获得的最高分
        Pair[][] dp = new Pair[len][len];
        // base case 只有一个数字时先手最高即为那个数字，后手最高为0
        for (int i = 0; i < len; i++) {
            dp[i][i] = new Pair(nums[i], 0);
        }

        // dp数组的初始值是斜着的，所以从下到上，从左到右计算数组。
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                // 先手选最左边的值
                int left = nums[i] + dp[i + 1][j].sec;
                // 先手选最右边的值
                int right = nums[j] + dp[i][j - 1].sec;
                Pair pair = new Pair();
                // 由于题目希望先手赢，所以先手选最大值，后手是由先手的选择决定的，随之改变即可
                if (left > right) {
                    pair.fir = left;
                    pair.sec = dp[i + 1][j].fir;
                } else {
                    pair.fir = right;
                    pair.sec = dp[i][j - 1].fir;
                }
                dp[i][j] = pair;
            }
        }

        return dp[0][len - 1].fir >= dp[0][len - 1].sec;
    }


    public static class Pair {
        public int fir;
        public int sec;

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }

        public Pair(){}
    }
}
