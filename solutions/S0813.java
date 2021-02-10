package solutions;

/**
 * 813. 最大平均值和的分组
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 *
 * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
 *
 * 示例:
 * 输入:
 * A = [9,1,2,3,9]
 * K = 3
 * 输出: 20
 * 解释:
 * A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 A 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 */
public class S0813 {
    public double largestSumOfAverages(int[] A, int K) {
        int lenA = A.length;
        double[][] dp = new double[lenA][K];
        double[] preSum = new double[lenA];
        preSum[0] = A[0];
        dp[0][0] = A[0];
        for(int i = 1; i < lenA; i++) {
            preSum[i] = preSum[i-1] + A[i];
            dp[i][0] = preSum[i]/(i+1);
        }
        for(int i = 0; i < lenA; i++) {
            for(int j = 1; j<K;j++) {
                for(int t = 0; t<i;t++) {
                    dp[i][j] = Math.max(dp[i][j], dp[t][j-1]+(preSum[i]-preSum[t])/(i-t));
                }
            }
        }
        return dp[lenA-1][K-1];
    }
}
