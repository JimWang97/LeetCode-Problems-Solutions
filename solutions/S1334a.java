package solutions;

import java.util.Arrays;

/**
 * 1334. 阈值距离内邻居最少的城市
 * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数
 * distanceThreshold。
 *
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 *
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * 输出：3
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * 城市 0 -> [城市 1, 城市 2]
 * 城市 1 -> [城市 0, 城市 2, 城市 3]
 * 城市 2 -> [城市 0, 城市 1, 城市 3]
 * 城市 3 -> [城市 1, 城市 2]
 * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 */
public class S1334a {
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for(int[] edge : edges) {
                dp[edge[0]][edge[1]] = edge[3];
                dp[edge[1]][edge[0]] = edge[3];
            }
            // 这一部分就是floyd算法，其实就是一个dp**
            for(int k = 0; k < n; k++) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(i==j||dp[i][k]==Integer.MAX_VALUE || dp[k][j]==Integer.MAX_VALUE){
                            continue;
                        }
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                    }
                }
            }

            int ans = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n;i++) {
                int sum = 0;
                for(int j = 0; j < n; j++) {
                    if(i!=j&&dp[i][j]<=distanceThreshold){
                        sum++;
                    }
                }
                if(sum<=min) {
                    ans = i;
                    min = sum;
                }
            }
            return ans;
        }
    }
}
