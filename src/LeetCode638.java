import java.util.ArrayList;
import java.util.List;

public class LeetCode638 {
    List<Integer> price;
    List<List<Integer>> special;

    int specialCost = 0;
    int min = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>> newSpecial = new ArrayList<>();
        // 去除那些大礼包还不如单买更便宜的情况
        for (List<Integer> list : special) {
            int cost = 0;
            for (int i = 0; i < price.size(); i++) {
                cost += list.get(i) * price.get(i);
            }
            if (cost > list.get(price.size())){
                newSpecial.add(list);
            }
        }

        this.price = price;
        this.special = newSpecial;
        backtrack(needs, 0);
        return min;
    }

    private void backtrack(List<Integer> needs, int index) {
        if (specialCost >= min) {
            return;
        }

        boolean usedSpecial = false;
        for (int i = index; i < special.size(); i++) {
            if (!canUseSpecial(needs, special.get(i))) {
                continue;
            }
            usedSpecial = true;
            // 可以买 specials[i] 这个大礼包
            // 做出购买的选择
            specialCost += special.get(i).get(price.size());
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) - special.get(i).get(j));
            }
            // 因为每个元素可以复选，所以下次回溯依然从 i 开始
            backtrack(needs, i);
            // 撤销购买的选择
            specialCost -= special.get(i).get(price.size());
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) + special.get(i).get(j));
            }
        }

        if (!usedSpecial) {
            // 无法使用大礼包，只能单买
            int sum = 0;
            for (int i = 0; i < needs.size(); i++) {
                sum += needs.get(i) * price.get(i);
            }
            // 单买的价格加上之前的大礼包的价格
            min = Math.min(min, sum + specialCost);
        }
    }

    private boolean canUseSpecial(List<Integer> needs, List<Integer> special) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i)) {
                return false;
            }
        }
        return true;
    }


}
