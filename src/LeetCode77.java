import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
}
class Solution77 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return result;
    }
    public void backTracking(int n,int k, int startIndex){
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <=n ; i++) {
            path.add(i);
            backTracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}

//来举一个例子，n = 4，k = 4的话，那么第一层for循环的时候，从元素2开始的遍历都没有意义了。 在第二层for循环，从元素3开始的遍历都没有意义了。
class Solution77_youHua {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return result;
    }
    public void backTracking(int n,int k, int startIndex){
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1 ; i++) {
            path.add(i);
            backTracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}