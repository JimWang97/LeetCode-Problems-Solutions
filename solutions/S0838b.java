package solutions;

/**
 * 838. 推多米诺
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 *
 * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
 *
 *
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 *
 * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 *
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 *
 * 返回表示最终状态的字符串。
 *
 * 示例 1：
 *
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 *
 * 就是从左往右遍历，如果碰到R并且右边还有的话，就给这个R右边一个牌往右倒的值，因为此时右边没有遍历过，如果右边是0，那么就让右边的往右倒的时间+1（值越大表示传递到这里的时间越长），然后如果碰到往左倒的，那就从这个开始向左遍历（值的绝对值越小说明和当前挨得越近）。直到，左边的值比右边绝对值大1，这样说明这块不用倒了，两边平衡。
 */
public class S0838b {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (dominoes.charAt(i) == 'R') dp[i] = 1;
            else if (dominoes.charAt(i) == 'L') dp[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            if (dp[i] > 0 &&  i + 1 < len && dp[i+1] == 0) dp[i+1] = dp[i] + 1;
            int j = i;
            while (dp[j] < 0 && j - 1 >= 0 && (dp[j-1] == 0 || dp[j] + dp[j-1] > 0)) {
                if (dp[j] + dp[j-1] == 1) {
                    dp[j-1] = 0;
                    break;
                } else {
                    dp[j-1] = dp[j] - 1;
                }
                --j;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) sb.append(dp[i] > 0 ? 'R' : dp[i] < 0 ? 'L' : '.');
        return sb.toString();
    }
}
