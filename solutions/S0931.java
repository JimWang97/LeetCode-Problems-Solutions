package solutions;

/**
 * 931. 下降路径最小和
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 *
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：12
 * 解释：
 * 可能的下降路径有：
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * 和最小的下降路径是 [1,4,7]，所以答案是 12。
 */
public class S0931 {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int [row][col];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i];
            ans = Math.min(ans, dp[0][i]);
        }
        if(row==1) {
            return ans;
        }
        ans = Integer.MAX_VALUE;
        for(int i = 1; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int min = dp[i-1][j];
                if(j>0) {
                    min = Math.min(min, dp[i-1][j-1]);
                }
                if(j<col-1) {
                    min = Math.min(min, dp[i-1][j+1]);
                }
                dp[i][j] = min + matrix[i][j];
                if(i==row-1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
