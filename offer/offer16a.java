package offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 */
public class offer16a {
    public double myPow(double x, int n) {
        double ans = 1;
        for(int i = n; i!=0; i/=2, x*=x) {
            if(i%2!=0) {
                ans *= x;
            }
        }
        return n<0? 1.0/ans: ans;
    }
}
