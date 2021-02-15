package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 764. 最大加号标志
 * 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1
 * 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
 *
 * 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k"
 * 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
 *
 *
 *
 * k 阶轴对称加号标志示例:
 *
 * 阶 1:
 * 000
 * 010
 * 000
 *
 * 阶 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 *
 * 阶 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 *
 *
 * 示例 1：
 *
 * 输入: N = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释:
 *
 * 11111
 * 11111
 * 11111
 * 11111
 * 11011
 *
 * 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 */
public class S0764 {
    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        List<int[]> ls = Arrays.asList(mines);
        int[][][] dp = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) dp[i][j][k] = 1;
            }
        }
        for (int[] z : mines) {
            for (int k = 0; k < 2; k++) dp[z[0]][z[1]][k] = 0;
        }
        for(int i = 1; i < N; i++) {
            if(dp[0][i][1]!=0) {
                dp[0][i][1] = dp[0][i-1][1]+1;
            }
        }
        for(int i = 1; i < N; i++) {
            if(dp[i][0][0]!=0) {
                dp[i][0][0] = dp[i - 1][0][0] + 1;
            }
        }
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < N; j++) {
                if(dp[i][j][0]!=0) {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N;i++) {
            for(int j = 0; j< N; j++) {
                int len = Math.min(dp[i][j][0], dp[i][j][1]);
                if(len>ans) {
                    for(int t=ans+1;t<=len;t++) {
                        if(i+t-1<N && j+t-1<N &&dp[i+t-1][j][0]>=t && dp[i][j+t-1][1]>=t) {
                            ans = t;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        orderOfLargestPlusSign(5, new int[][]{{4,2}});
    }
}
