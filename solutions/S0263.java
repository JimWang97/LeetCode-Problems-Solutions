package solutions;

/**
 * 263. 丑数
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 */
public class S0263 {
    class Solution {
        public boolean isUgly(int n) {
            while(n%5==0) {
                n/=5;
            }
            while(n%3==0) {
                n/=3;
            }
            while(n%2==0) {
                n/=2;
            }
            return n==1;
        }
    }
}
