import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
}
class Solution216 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k,n,1);
        return result;
    }
    //每次递归target减去当前值，target==0时path中元素和为n
    public void backTracking(int k,int target,int startIndex){
        //剪枝
        if (target<0) return;
        //终止条件
        if (path.size()==k){
            if (target==0){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            backTracking(k,target-i,i+1);
            path.remove(path.size()-1);
        }

    }

}
