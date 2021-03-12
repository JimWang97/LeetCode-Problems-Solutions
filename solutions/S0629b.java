package solutions;

/**
 * 629. K个逆序对数组
 * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 *
 * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
 *
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 *
 * 示例 1:
 *
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释:
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 *
 * f(i, j) = f(i - 1, j) + f(i - 1, j - 1) + ... + f(i - 1, j - i + 1)
 * f(i, j - 1) = f(i - 1, j - 1) + f(i - 1, j - 2) + ... + f(i - 1, j - i)
 * 两个可以优化
 * f(i, j) - f(i - 1, j) = f(i, j - 1) - f(i - 1, j - i)
 * ==> f(i, j) = f(i, j - 1) + f(i - 1, j) - f(i - 1, j - i)
 */
public class S0629b {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for(int j = 1;j<= i * (i - 1) / 2&&j<=k;j++) {
                int val = (dp[i - 1][j] + MOD - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % MOD;
                dp[i][j] = (dp[i][j - 1] + val) % MOD;
            }
        }
        return dp[n][k] % MOD;
    }
}
