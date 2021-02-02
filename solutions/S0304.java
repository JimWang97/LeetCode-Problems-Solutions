package solutions;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class S0304 {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if(row==0) {
            return;
        }
        int col = matrix[0].length;
        dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            int sum = 0;
            for(int j = 0 ; j < col; j++) {
                sum += matrix[i][j];
                dp[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i<=row2; i++) {
            sum = sum + dp[i][col2];
            if(col1>0) {
                sum -= dp[i][col1];
            }
        }
        return sum;
    }
}
