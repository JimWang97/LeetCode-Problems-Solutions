package solutions;

/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 *
 * 背包问题
 * dp[i] = dp[i] + dp[i-coin]
 */
public class interview_08_11a {
    public int waysToChange(int n) {
        long[] dp = new long[n+1];
        int[] coins = {1, 5, 10, 25};
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <=n ;i++) {
                dp[i] = (dp[i] + dp[i-coin]) %1000000007;
            }
        }
        return (int) dp[n];
    }
}
