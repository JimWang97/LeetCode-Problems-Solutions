package solutions;

/**
 * 688. “马”在棋盘上的概率
 * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。
 *
 * 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。
 *
 * 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
 *
 *
 *
 *
 *
 *
 *
 * 现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
 *
 * 求移动结束后，“马” 仍留在棋盘上的概率。
 *
 *
 *
 * 示例：
 *
 * 输入: 3, 2, 0, 0
 * 输出: 0.0625
 * 解释:
 * 输入的数据依次为 N, K, r, c
 * 第 1 步时，有且只有 2 种走法令 “马” 可以留在棋盘上（跳到（1,2）或（2,1））。对于以上的两种情况，各自在第2步均有且只有2种走法令 “马” 仍然留在棋盘上。
 * 所以 “马” 在结束后仍在棋盘上的概率为 0.0625。
 */
public class S0688 {
    public double knightProbability(int N, int K, int r, int c) {
        if(K==0) {
            return 1;
        }
        if(r>=N || c>=N) {
            return 0;
        }
        double[][][] dp = new double[N][N][K+1];
        dp[r][c][0] = 1;
        int[] dx = new int[]{-2,-2,-1,-1,1,1,2,2};
        int[] dy = new int[]{-1,1,-2,2,-2,2,-1,1};
        double ans = 0;
        for(int i = 1; i <= K; i++) {
            for(int row = 0; row < N; row++){
                for(int col = 0; col < N; col++){
                    for(int k = 0; k < 8; k++) {
                        if(isBoard(row+dx[k],col+dy[k],N)) {
                            dp[row][col][i] += dp[row+dx[k]][col+dy[k]][i-1]*1.0/8.0;
                            if(i==K) {
                                ans+= dp[row+dx[k]][col+dy[k]][i-1]*1.0/8.0;

                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public boolean isBoard(int x, int y, int N) {
        return x>=0 && x<N && y>=0 && y < N;
    }
}
