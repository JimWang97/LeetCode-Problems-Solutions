package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
 *
 * 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
 *
 * 示例：
 *
 * 输入：
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * 输出：
 * false
 *
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 */
public class S0464a {
    /**
     * 记忆化回溯（也称为递归+备忘录），自顶向下
     * 采用记忆化后的时间复杂度为O(2^n)(如果不进行记忆的话，时间复杂度将是O(n!))，可以理解为已经缩成了只有一个分支了
     * 然后为什么要进行记忆化：
     * 因为我们发现，例如[2,3]和[3,2]之后的玩家选择状态都是一样的，都是可以从除了2,3之外的
     * 数字进行选择，那么就可以对选择2和3后第一个玩家能不能赢进行记忆存储
     * 这里采用state[]数组存储每个数字是否都被选过，选过则记录为1，然后我们将state.toString()
     * 使得[2,3]和[3,2]它们的结果都是一样的"0011"，作为key，存储在HashMap中，value是选了2和3
     * 之后第一个玩家是否稳赢
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if((maxChoosableInteger * (maxChoosableInteger+1))/2 < desiredTotal) {
            return false;
        }
        int[] state = new int[maxChoosableInteger + 1];
        Map<String, Boolean> map = new HashMap<>();
        return dfs(maxChoosableInteger, desiredTotal, state, map);
    }

    public boolean dfs(int maxChoosableInteger, int desiredTotal, int[] state, Map<String, Boolean> map) {
        String ss = Arrays.toString(state);
        if(map.containsKey(ss)) {
            return map.get(ss);
        }
        for(int i = 1; i <= maxChoosableInteger; i++) {
            if(state[i]!=1) {
                state[i] = 1;
                if(desiredTotal - i<=0 || !dfs(maxChoosableInteger, desiredTotal-i, state, map)) {
                    map.put(ss, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        map.put(ss, false);
        return false;
    }

}
