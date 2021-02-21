package solutions;

/**
 * 1140. 石子游戏 II
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 *
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 *
 * 游戏一直持续到所有石子都被拿走。
 *
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 *
 *
 *
 * 示例：
 *
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 *
 * 从后往前逆推。最后一步就是把能拿的全拿了。每次都是右边剩多少最好全拿了。
 * 如果不能拿完，那就让另一个人尽可能的少拿
 * i + 2M >= len, dp[i][M] = sum[i : len - 1], 剩下的堆数能够直接全部取走，那么最优的情况就是剩下的石子总和
 * i + 2M < len, dp[i][M] = max(dp[i][M], sum[i : len - 1] - dp[i + x][max(M, x)]), 其中 1 <= x <=
 * 2M，剩下的堆数不能全部取走，那么最优情况就是让下一个人取的更少。对于我所有的x取值，下一个人从x开始取起，M变为max(M, x)，所以下一个人能取dp[i + x][max(M, x)]，我最多能取sum[i : len -
 * 1] - dp[i + x][max(M, x)]。
 *
 * 作者：lgh18
 * 链接：https://leetcode-cn.com/problems/stone-game-ii/solution/java-dong-tai-gui-hua-qing-xi-yi-dong-17xing-by-lg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class S1140a {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len+1];
        int sum = 0;
        for(int i = len-1; i>=0;i--) {
            sum += piles[i];
            for(int M = 1; M <= len; M++) {
                if(i+2*M >= len) {
                    dp[i][M] = sum;
                } else {
                    for(int x = 1; x<=2*M;x++) {
                        dp[i][M] = Math.max(dp[i][M], sum-dp[i+x][Math.max(M,x)]); // 从i+x拿起，拿M或x个，如果M大就拿M，也可能x>M，就拿x个
                    }
                }
            }
        }
        return dp[0][1];
    }
}
