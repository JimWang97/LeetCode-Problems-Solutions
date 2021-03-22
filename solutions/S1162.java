package solutions;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 *
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果网格上只有陆地或者海洋，请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
 */
public class S1162 {
    class Solution {
        public int maxDistance(int[][] grid) {
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            Queue<int[]> queue = new ArrayDeque<>();
            int m = grid.length, n = grid[0].length;
            // 先把所有的陆地都入队。
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[] {i, j});
                    }
                }
            }

            boolean hasOcean  = false;
            int[] point = null;
            while(!queue.isEmpty()) {
                point = queue.poll();
                int x = point[0], y = point[1];
                for(int i = 0; i < 4; i++) {
                    int newX = x+dx[i];
                    int newY = y+dy[i];
                    if(newX>grid.length||newX<0||newY<0||newY>grid[0].length||grid[newX][newY]!=0) {
                        continue;
                    }
                    queue.add(new int[]{newX, newY});
                    grid[newX][newY] = grid[x][y]+1;
                    hasOcean = true;
                }
            }
            // 没有陆地或者没有海洋，返回-1。
            if (point == null || !hasOcean) {
                return -1;
            }

            // 返回最后一次遍历到的海洋的距离。
            return grid[point[0]][point[1]] - 1;
        }
    }
}
