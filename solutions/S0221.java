package solutions;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 *
 * dp[i][j]表示第i行j列开始的左上角的正方形边长
 * dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1,j-1]+1) 当matrix[i][j]==1时
 */
public class S0221 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int ans = 0;
        dp[0][0] = matrix[0][0] == '1' ? 1:0;
        if(dp[0][0]==1) {
            ans = 1;
        }
        for(int i = 1; i < row; i++) {
            if(matrix[i][0]=='1') {
                dp[i][0] = 1;
                ans = 1;
            }
        }
        for(int i = 1; i < col; i++) {
            if(matrix[0][i]=='1') {
                dp[0][i] = 1;
                ans = 1;
            }
        }

        for(int i = 1;i<row;i++) {
            for(int j = 1;j<col;j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1])+1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans*ans;
    }
}
