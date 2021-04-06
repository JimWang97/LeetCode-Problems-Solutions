package solutions;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 */
public class S0371b {
    class Solution {
        public int getSum(int a, int b) {
            if (a==0) return b;
            if (b==0) return a;
            int lower;
            int carrier;
            while (true) {
                lower = a^b;    // 计算低位
                carrier = a&b;  // 计算进位
                if (carrier==0) break;
                a = lower;
                b = carrier<<1;
            }
            return lower;
        }
    }
}
