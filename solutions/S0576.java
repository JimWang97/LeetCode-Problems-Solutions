package solutions;

/**
 * 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N
 * 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 * 输出: 6
 */
public class S0576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N==0) {
            return 0;
        }
        int[][][] dp = new int[N][m][n];
        int[] dx = new int[]{1,-1,0, 0};
        int[] dy = new int[]{0, 0,1,-1};
        for(int col = 0; col < n; col++) {
            dp[0][0][col] ++;
            dp[0][m-1][col] ++;
        }
        for(int row = 0; row < m; row++) {
            dp[0][row][0] ++;
            dp[0][row][n-1] ++;
        }
        for(int step = 1; step < N; step++) {
            for(int row = 0; row < m; row++) {
                for(int col = 0; col < n; col++) {
                    for(int k = 0; k < 4; k++) {
                        int nx = row+dx[k];
                        int ny = col+dy[k];
                        if(inBoard(nx, ny, m, n)) {
                            dp[step][row][col] = (dp[step][row][col] + dp[step-1][nx][ny])%1000000007;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int step=0;step<N;step++){
            ans = (ans + dp[step][i][j]) % 1000000007;
        }
        return ans;
    }
    public boolean inBoard(int nx, int ny, int m, int n) {
        return nx>=0 && nx<m && ny>=0 && ny<n;
    }
}
