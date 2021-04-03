package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1276. 不浪费原料的汉堡制作方案
 * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
 *
 * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
 *
 * 巨无霸汉堡：4 片番茄和 1 片奶酪
 * 小皇堡：2 片番茄和 1 片奶酪
 * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
 *
 * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tomatoSlices = 16, cheeseSlices = 7
 * 输出：[1,6]
 * 解释：制作 1 个巨无霸汉堡和 6 个小皇堡需要 4*1 + 2*6 = 16 片番茄和 1 + 6 = 7 片奶酪。不会剩下原料。
 */
public class S1276 {
    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            if(tomatoSlices%2==1||tomatoSlices<cheeseSlices*2||tomatoSlices>cheeseSlices*4) return new ArrayList<Integer>();
            int tmp = 2*cheeseSlices;
            int ans1 = 0, ans2 = 0;
            if(tmp<tomatoSlices) {
                ans1 = (tomatoSlices-tmp)/2;
            }
            ans2 = (tomatoSlices-4*ans1)/2;
            List<Integer> ans = new ArrayList<>();
            ans.add(ans1);
            ans.add(ans2);
            return ans;
        }
    }
}
