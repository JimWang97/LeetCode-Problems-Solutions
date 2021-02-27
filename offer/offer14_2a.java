package offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 记一下数学做法
 */
public class offer14_2a {
    //    public int cuttingRope(int n) {
//        if(n<2) {
//            return 0;
//        }
//        BigInteger[] dp = new BigInteger[n+1];
//        Arrays.fill(dp, BigInteger.valueOf(1));
//        for (int i = 3; i <= n; i++) {
//            for (int j = 1; j < i; j++) {
//                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
//            }
//        }
//        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
//    }
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        } else if (n == 4) {
            return 4;
        }

        long ans = 1;
        while (n > 4) {
            ans = ans * 3 % 1000000007;
            n -= 3;
        }
        if (n != 0) {
            ans = ans * n % 1000000007;
        }

        return (int) ans;
    }

}
