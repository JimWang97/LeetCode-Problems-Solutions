
package solutions;

/**
 * 1039. 多边形三角剖分的最低得分
 * 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。
 *
 * 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。
 *
 * 返回多边形进行三角剖分后可以得到的最低分。
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 */
class S1039a {
    public int minScoreTriangulation(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        for(int i = len-3; i>=0; i--){
            for(int j = i+2; j<len;j++) {
                for(int k = i+1;k<j;k++) {
                    if(dp[i][j]==0) {
                        dp[i][j]= A[i] * A[j] * A[k] + dp[i][k] + dp[k][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j],A[i] * A[j] * A[k] + dp[i][k] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}
