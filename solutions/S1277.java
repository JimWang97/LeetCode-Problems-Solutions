package solutions;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 */
public class S1277 {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][]dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            System.arraycopy(matrix[i],0,dp[i],0, col);
        }
        int ans = 0;
        for(int i = 0; i<row; i++) {
            for(int j = 0; j < col; j++) {
                if(i!=0&&j!=0) {
                    if(matrix[i][j]==0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1])+1;
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
