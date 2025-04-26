import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {
    /**
     * 设 n 阶格雷码集合为 G(n)，则 G(n+1) 阶格雷码可以通过以下三步得到：
     * 给 G(n) 阶格雷码每个元素二进制形式前面添加 0，得到 G′(n)；
     * 设 G(n) 集合倒序（镜像）为 R(n)，给 R(n) 每个元素二进制形式前面添加 1，得到 R′(n)；
     * G(n+1)=G′(n) ∪ R′(n) 拼接两个集合即可得到下一阶格雷码。
     */
    public List<Integer> grayCode(int n) {
        /**
         * 由于最高位前默认为 0，因此 G′(n)=G(n)，只需在 res(即 G(n) )后添加 R′(n) 即可；
         * 计算 R′(n)：执行 head = 1 << i 计算出对应位数，以给 R(n) 前添加 1 得到对应 R′(n)；
         * 倒序遍历 res(即 G(n) )：依次求得 R′(n) 各元素添加至 res 尾端，遍历完成后 res(即 G(n+1))。
         */
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
