package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 */
public class S0781 {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int a : answers) {
                Integer tmp = map.getOrDefault(a, 0);
                map.put(a, tmp+1);
            }
            int ans = 0;
            Set<Integer> keys = map.keySet();
            for(int key : keys) {
                if(key==0) {
                    ans+=map.get(key);
                } else {
                    int tp = map.get(key);
                    if(tp%(key+1)==0) {
                        ans+=tp;
                    } else {
                        ans+=tp;
                        ans+=(key+1-tp%(key+1));
                    }
                }
            }
            return ans;
        }
    }
}
