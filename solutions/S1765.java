package solutions;

import java.util.*;

/**
 * 1765. 地图中的最高点
 * 给你一个大小为 m x n 的整数矩阵 isWater ，它代表了一个由 陆地 和 水域 单元格组成的地图。
 *
 * 如果 isWater[i][j] == 0 ，格子 (i, j) 是一个 陆地 格子。
 * 如果 isWater[i][j] == 1 ，格子 (i, j) 是一个 水域 格子。
 * 你需要按照如下规则给每个单元格安排高度：
 *
 * 每个格子的高度都必须是非负的。
 * 如果一个格子是是 水域 ，那么它的高度必须为 0 。
 * 任意相邻的格子高度差 至多 为 1 。当两个格子在正东、南、西、北方向上相互紧挨着，就称它们为相邻的格子。（也就是说它们有一条公共边）
 * 找到一种安排高度的方案，使得矩阵中的最高高度值 最大 。
 *
 * 请你返回一个大小为 m x n 的整数矩阵 height ，其中 height[i][j] 是格子 (i, j) 的高度。如果有多种解法，请返回 任意一个 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：isWater = [[0,1],[0,0]]
 * 输出：[[1,0],[2,1]]
 * 解释：上图展示了给各个格子安排的高度。
 * 蓝色格子是水域格，绿色格子是陆地格。
 */
public class S1765 {
    class Solution {
        int rows, cols;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        public int[][] highestPeak(int[][] isWater) {
            rows = isWater.length;
            cols = isWater[0].length;
            Queue<int[]> q = new LinkedList<>();
            int[][] ans = new int[rows][cols];
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(isWater[i][j]==1) {
                        q.offer(new int[]{i,j});
                    }
                }
            }
            while(!q.isEmpty()) {
                int[] p = q.poll();
                int x = p[0], y = p[1];
                for(int i = 0;i < 4; i++) {
                    int ddx = x+dx[i], ddy = y+dy[i];
                    if(ddx<0||ddx>=rows||ddy<0||ddy>=cols||isWater[ddx][ddy]==1) continue;
                    ans[ddx][ddy] = ans[x][y]+1;
                    isWater[ddx][ddy] = 1;
                    q.offer(new int[]{ddx,ddy});
                }
            }
            return ans;
        }

    }
}
