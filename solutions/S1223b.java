package solutions;

/**
 * 1223. 掷骰子模拟
 * 有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。
 *
 * 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。
 *
 * 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。
 *
 * 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, rollMax = [1,1,2,2,2,3]
 * 输出：34
 * 解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2
 * = 34。
 */
public class S1223b {
    public int dieSimulator(int n, int[] rollMax) {
        long[][][] dp = new long[n][7][17];
        for(int i = 1; i < 7; i++) {
            dp[0][i][1] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < 7; j++) { //判断j出现的连续次数
                for(int k = 1; k < 7; k++) { // 上一次出现的是k
                    if(j!=k) {
                        for(int t = 1; t <= rollMax[k-1]; t++) {
                            dp[i][j][1] += dp[i-1][k][t];
                            dp[i][j][1] %=  1000000007;
                        }
                    } else {
                        for(int t = 1; t <= rollMax[k-1]; t++){
                            dp[i][j][t+1] += dp[i-1][k][t];
                            dp[i][j][t+1] %= 1000000007;
                        }
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 1; i < 7; ++i) {
            for (int t = 1; t <= rollMax[i-1]; ++t) {
                sum = (sum + dp[n - 1][i][t]) % 1000000007;
            }
        }
        return (int)sum;
    }
}
