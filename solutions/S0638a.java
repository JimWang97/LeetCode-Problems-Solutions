package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 638. 大礼包
 * 在LeetCode商店中， 有许多在售的物品。
 *
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 *
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 *
 * 任意大礼包可无限次购买。
 *
 * 示例 1:
 *
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释:
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
 */
public class S0638a {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        return shopping(price, special, needs, map);
    }

    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int j = 0, res = dot(needs, price);
        for(List<Integer> s : special) {
            ArrayList<Integer> clone = new ArrayList<>(needs);
            for(j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if(diff<0) {
                    break;
                }
                clone.set(j, diff);
            }
            if(j == needs.size()) {
                res = Math.min(res, s.get(j) + shopping(price, special, clone, map));
            }
        }
        map.put(needs, res);
        return res;
    }

    public int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for(int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
}
