package offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class offer65a {
    public int add(int a, int b) {
        while(b!=0) {
            // 这个表示无进位的加法
            int tmp = a^b;
            // b是进位。因此每次都是无进位的加法+进位即可
            // 直到无进位了位置
            b = ((a&b)<<1);
            a=tmp;
        }
        return a;
    }
}
