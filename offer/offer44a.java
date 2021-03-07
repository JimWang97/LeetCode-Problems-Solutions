package offer;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 *
 * 可以发现规律 占1位的10个，占2位的10-99 90个。占3位的 100-999 900个。
 * 可以计算获得是哪一个数中第几位。
 */
public class offer44a {
    public int findNthDigit(int n) {
        int digit = 1;
        long num = 9, start = 1;
        while(n>digit*start*num) {
            n -= digit*start*num;
            digit += 1;
            start*=10;
        }
        long d = start + (n-1) / digit;
        return Long.toString(d).charAt((n-1)%digit)-'0';
    }
}
