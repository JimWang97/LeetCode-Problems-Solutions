package solutions;

/**
 * 1139. 最大的以 1 为边界的正方形
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 */
public class S1139a {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 0是row  1是col
        int[][][] dp = new int[row+1][col+1][2];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++) {
                if (grid[i-1][j-1] == 1) {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col ; j++) {
                int minLen = Math.min(dp[i][j][0], dp[i][j][1]);
                for(int k = minLen; k >=1;k--){
                    if(dp[i-k+1][j][1]>=k && dp[i][j-k+1][0]>=k){
                        res = Math.max(res, k);
                        break;
                    }
                }
            }
        }
        return res*res;
    }
}
