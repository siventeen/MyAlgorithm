import java.util.Arrays;

public class LeetCode1079 {
    private int res = 0;
    private boolean[] used;
    public int numTilePossibilities(String tiles) {
        used = new boolean[tiles.length()];
        char[] chars = tiles.toCharArray();
        // 先排序，让相同的元素靠在一起
        Arrays.sort(chars);
        backtrack(chars);
        return res;
    }

    private void backtrack(char[] chars) {

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝, 如果当前元素和前一个元素相同，且前一个元素没有被使用过，则跳过
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            res++;
            used[i] = true;
            backtrack(chars);
            used[i] = false;
        }
    }
}
