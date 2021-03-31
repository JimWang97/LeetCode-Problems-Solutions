package solutions;

import java.util.PriorityQueue;

/**
 * 407. 接雨水 II
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 *
 *
 * 示例：
 *
 * 给出如下 3x6 的高度图:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * 返回 4 。
 *
 *
 * 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
 *
 *
 *
 *
 *
 * 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 *
 * 优先队列，先把最小的弹出，如果最小的地方会漏，说明接不住水
 */
public class S0407 {
    class Solution {
        public int trapRainWater(int[][] heightMap) {
            if(heightMap==null||heightMap.length==0) return 0;
            int rows = heightMap.length;
            int cols = heightMap[0].length;
            boolean[][] visited = new boolean[rows][cols];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);

            for(int i = 0; i < rows;i++) {
                for(int j = 0; j < cols; j++) {
                    if(i==rows-1||i==0||j==0||j==cols-1) {
                        pq.offer(new int[]{i,j,heightMap[i][j]});
                        visited[i][j] = true;
                    }
                }
            }
            int ans = 0;
            int[] dirs = {-1,0,1,0,-1};
            while(!pq.isEmpty()) {
                int[] poll = pq.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = poll[0]+dirs[k];
                    int ny = poll[1]+dirs[k+1];
                    if(nx>=0&&nx<rows&&ny>=0&&ny<cols&&!visited[nx][ny]) {
                        if(poll[2]>heightMap[nx][ny]) {
                            ans += poll[2] - heightMap[nx][ny];
                        }
                        pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], poll[2])});
                        visited[nx][ny] = true;
                    }
                }
            }
            return ans;
        }
    }
}
