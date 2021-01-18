package solutions;

import java.util.Arrays;

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
https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/k-zhan-zhong-zhuan-nei-zui-bian-yi-de-hang-ban-b-2/
 */
public class S0787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int [n][K+1];

        for(int i = 0;i<n;i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int[] f : flights) {
            if(f[0]==src){
                dp[f[1]][0] = f[2];
            }
        }

        for(int i = 0;i<=K;i++){
            dp[src][i] = 0;
        }

        for(int k=1;k<=K;k++){
            for(int[] f : flights) {
                if(dp[f[0]][k-1]!=Integer.MAX_VALUE) {
                    dp[f[1]][k] = Math.min(dp[f[1]][k], dp[f[0]][k-1]+f[2]);
                }
            }
        }
        return dp[dst][K] == Integer.MAX_VALUE ? -1 : dp[dst][K];
    }
}