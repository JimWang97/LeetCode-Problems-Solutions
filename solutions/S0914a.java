package solutions;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 最大公约数
 */
public class S0914a {
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int[] count = new int[10000];
            for (int c: deck) {
                count[c]++;
            }

            int g = -1;
            for (int i = 0; i < 10000; ++i) {
                if (count[i] > 0) {
                    if (g == -1) {
                        g = count[i];
                    } else {
                        g = gcd(g, count[i]);
                    }
                }
            }
            return g >= 2;
        }

        public int gcd(int x, int y) {
            return x == 0 ? y : gcd(y % x, x);
        }
    }

}
