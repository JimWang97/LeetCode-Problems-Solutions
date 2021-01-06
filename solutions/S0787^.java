package solutions;

/**
 * 787. K 站中转内最便宜的航班
有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。

现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。

 

示例 1：

输入: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
输出: 200
解释: 
城市航班图如下


从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 */
public class S0787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][][] dp = new int[n][n][K+1];
        for(int[] f : flights){
            dp[f[0]][f[1]][0] = f[2];
        }
        for(int k = 1; k <= K; k++){
            for(int i = 0;i < n; i++){ //起点
                for(int j = 0; j < n; j++) { //中专点
                    if(dp[i][j][k-1]!=0) {
                        for(int z = 0; z<n;z++){
                            if(dp[j][z][k-1]!=0) {
                                if(dp[i][z][k]==0){
                                    dp[i][z][k] = dp[i][j][k-1] +dp[j][z][k-1];
                                } else {
                                    dp[i][z][k] = Math.min(dp[i][j][k-1] +dp[j][z][k-1], dp[i][z][k]);
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k<=K; k++){
            if(dp[src][dst][k]!=0) ans = Math.min(ans, dp[src][dst][k]);
        }
        return dp[src][dst][K]==Integer.MAX_VALUE?-1:dp[src][dst][K];
    }
}