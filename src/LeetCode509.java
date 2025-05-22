public class LeetCode509 {
    public int fib(int n) {
        int a = 0, b = 1;
        if (n < 2) {
            return n;
        }
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
