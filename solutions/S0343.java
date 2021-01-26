package solutions;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 */
public class S0343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <=n ; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i-1; j>=i/2; j--) {
                max = Math.max(max, Math.max(dp[j],j) * Math.max(dp[i-j],i-j));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
