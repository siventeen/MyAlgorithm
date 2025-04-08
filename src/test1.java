import java.util.Arrays;

public class test1 {
    public static int Maxlen(int[] nums){
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(Maxlen(nums));
//        float f = 11.1;
        double d = 5.3E12;
        char c = '\r';
//        byte bb = 433;
    }
}
