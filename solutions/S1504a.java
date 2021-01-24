package solutions;

/**
 * 1504. 统计全 1 子矩形
 * 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,0,1],
 *             [1,1,0],
 *             [1,1,0]]
 * 输出：13
 * 解释：
 * 有 6 个 1x1 的矩形。
 * 有 2 个 1x2 的矩形。
 * 有 3 个 2x1 的矩形。
 * 有 1 个 2x2 的矩形。
 * 有 1 个 3x1 的矩形。
 * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
 */
public class S1504a {
    public int numSubmat(int[][] mat) {
        int res = 0;
        if(mat.length==0) {
            return res;
        }
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(mat[i][j]==0) {
                    continue;
                }
                dp[i][j] = j==0? 1:dp[i][j-1]+1;
                int min = dp[i][j];
                for(int k = i; k>=0; k--) {
                    min = Math.min(min, dp[k][j]);
                    res+=min;
                }
            }
        }
        return res;
    }
}
