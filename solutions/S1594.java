package solutions;

/**
 * 1594. 矩阵的最大非负积
 * 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 *
 * 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 *
 * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
 *
 * 注意，取余是在得到最大积之后执行的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[-1,-2,-3],
 *              [-2,-3,-3],
 *              [-3,-3,-2]]
 * 输出：-1
 * 解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
 *
 * dp[i][j][k] 表示位于[i][j]的最大值[1]或最小值[0]。
 * 因为路径中可能有负数，所以要同时记录最大值和最小值
 * dp[i][j][0] = min(dp[i-1][j][0]*grid[i][j], dp[i][j-1][0]*grid[i][j]) 当grid[i][j]>0时
 * dp[i][j][0] = min(dp[i-1][j][1]*grid[i][j], dp[i][j-1][1]*grid[i][j]) 当grid[i][j]<0
 */
public class S1594 {
    public int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long[][][] dp = new long[row][col][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for(int i = 1; i < row; i++) {
            if(grid[i][0]<0) {
                dp[i][0][0] = dp[i-1][0][1] * grid[i][0];
                dp[i][0][1] = dp[i-1][0][0] * grid[i][0];
            } else if(grid[i][0]>0) {
                dp[i][0][0] = dp[i-1][0][0] * grid[i][0];
                dp[i][0][1] = dp[i-1][0][1] * grid[i][0];
            }
        }
        for(int i = 1; i < col; i++) {
            if(grid[0][i]<0) {
                dp[0][i][0] = dp[0][i-1][1] * grid[0][i];
                dp[0][i][1] = dp[0][i-1][0] * grid[0][i];
            } else if(grid[0][i]>0) {
                dp[0][i][0] = dp[0][i-1][0] * grid[0][i];
                dp[0][i][1] = dp[0][i-1][1] * grid[0][i];
            }
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(grid[i][j]<0) {
                    dp[i][j][0] = Math.min(dp[i-1][j][1] * grid[i][j], dp[i][j-1][1] * grid[i][j]);
                    dp[i][j][1] = Math.max(dp[i-1][j][0] * grid[i][j], dp[i][j-1][0] * grid[i][j]);
                } else if(grid[i][j]>=0) {
                    dp[i][j][0] = Math.min(dp[i-1][j][0] * grid[i][j], dp[i][j-1][0] * grid[i][j]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1] * grid[i][j], dp[i][j-1][1] * grid[i][j]);
                }
            }
        }
        if(dp[row-1][col-1][1] < 0){
            return -1;
        }
        return (int)(dp[row-1][col-1][1]%(1000000007));
    }
}
