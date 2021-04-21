package solutions;

/**
 * 991. 坏了的计算器
 * 在显示着数字的坏计算器上，我们可以执行以下两种操作：
 *
 * 双倍（Double）：将显示屏上的数字乘 2；
 * 递减（Decrement）：将显示屏上的数字减 1 。
 * 最初，计算器显示数字 X。
 *
 * 返回显示数字 Y 所需的最小操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：X = 2, Y = 3
 * 输出：2
 * 解释：先进行双倍运算，然后再进行递减运算 {2 -> 4 -> 3}.
 */
public class S0991 {
    class Solution {
        int brokenCalc(int X, int Y) {
            int result = 0;
            while(X < Y)
            {
                if((Y % 2) == 0)
                {
                    Y /= 2;
                    result++;
                }
                else
                {
                    Y = (Y + 1) / 2;
                    result += 2;
                }
            }
            return result + X - Y;
        }
    }
}
