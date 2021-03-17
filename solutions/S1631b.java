package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0)
 * ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 *
 * bfs会超时
 *
 * 想象成二分查找，每次找当前消耗能量能否走到终点，可以的话就能量降低一半，不行的话增加一半。
 * 或者并查集，把两两块之间想成是edge，然后从小到大的顺序排height。然后往并查集里放，等到哪一刻左上角与右下角联通
 * 说明当前height就是最小消耗能量
 */
public class S1631b {
    class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            int left = 0, right = 999999, ans = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{0,0});
                boolean[] seen = new boolean[m * n];
                seen[0] = true;
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int x = cell[0], y = cell[1];
                    for (int i = 0; i < 4; ++i) {
                        int nx = x + dirs[i][0];
                        int ny = y + dirs[i][1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                            queue.offer(new int[]{nx, ny});
                            seen[nx * n + ny] = true;
                        }
                    }
                }
                if (seen[m * n - 1]) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
}
