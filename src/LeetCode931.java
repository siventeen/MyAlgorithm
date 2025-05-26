public class LeetCode931 {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = calculateValue(matrix, dp, i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[n - 1][i], res);
        }
        return res;
    }

    private int calculateValue(int[][] matrix, int[][] dp, int i, int j) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int start = 0;
        int end = n - 1;
        if (j > 0) {
            start = j - 1;
        }
        if (j < n - 1) {
            end = j + 1;
        }
        for (int k = start; k <= end; k++) {
            res = Math.min(res, matrix[i][j] + dp[i - 1][k]);
        }
        return res;
    }
}
