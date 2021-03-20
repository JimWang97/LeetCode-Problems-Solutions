package solutions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
 * 我们用 f(i, j) 表示数字 [1 .. i] 的排列中恰好包含 j 个逆序对的个数。在状态转移时，我们考虑数 i 放置的位置与逆序对个数的关系。我们在数字 [1 .. i - 1] 组成的排列中放入 i 时，有 i
 * 种放置方法：如果将 i 放在最后，则逆序对数量不变；如果将 i 放在倒数第二个，则逆序对数量增加 1；如果将 i 放在第一个，则逆序对数量增加 i - 1。这是因为 i 是 [1 .. i] 中的最大值，因此将它放置在 [1 .
 * . i - 1] 的排列中的任意一个位置，它都会与在它之后的那些数形成逆序对。如果它后面有 k 个数，则会形成 k 个逆序对。
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
