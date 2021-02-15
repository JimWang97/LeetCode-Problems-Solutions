package solutions;

/**
 * 1155. 掷骰子的N种方法
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 *
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 *
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：d = 1, f = 6, target = 3
 * 输出：1
 *
 * dp[d][d*f] 骰子数和最大点数,表示d个骰子，结果是d*f的组合情况
 * dp[i][j] += dp[i-1][j-k] k是所有一个骰子可能得到的点数
 */
public class S1155 {
    public int numRollsToTarget(int d, int f, int target) {
        if(target>d*f) {
            return 0;
        }
        int[][] dp = new int[d][d*f];
        int min = Math.min(f, target);
        for(int i = 0; i < min; i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<d;i++) {
            for(int j=i;j<d*f;j++) {
                for(int k = 1; j-k>=0 &&k <=f; k++) {
                    dp[i][j] = (dp[i][j]+dp[i-1][j-k])%1000000007;
                }
            }
        }
        return dp[d-1][target-1];
    }
}
