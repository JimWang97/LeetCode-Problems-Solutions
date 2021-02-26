package offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class offer10 {
    public int fib(int n) {
        if(n==0||n==1) {
            return n;
        }
        int[] dp = new int[n+1];
        int a = 0;
        int b = 1;
        int sum = 0;
        for(int i = 0; i < n;i++) {
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
