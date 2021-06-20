package competition.sweek246;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 *
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 *
 * 请你返回 grid2 中 子岛屿 的 数目
 *
 * 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,
 * 0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * 输出：3
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
 */
public class S3 {
    static class Solution {
        boolean visited[][];
        int[][] g1, g2;
        int row, col;
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int[] d = {1,0,-1,0,1};
            row = grid1.length;
            col = grid1[0].length;
            g1 = grid1;
            g2 = grid2;
            visited = new boolean[row][col];
            int ans = 0;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(!visited[i][j] && g2[i][j]==1) {
                        visited[i][j] = true;
                        Queue<Point> q = new LinkedList<>();
                        q.add(new Point(i,j));
                        boolean flag = true;
                        while(!q.isEmpty()) {
                            Point tp = q.poll();
                            if(grid1[tp.x][tp.y]!=1) {
                                flag=false;
                            }
                            for(int k = 0; k < 4; k++) {
                                int dx = tp.x+d[k], dy = tp.y+d[k+1];
                                if(dx<0||dx>=row||dy<0||dy>=col||visited[dx][dy]||grid2[dx][dy]!=1) continue;
                                q.add(new Point(dx, dy));
                                visited[dx][dy] = true;
                            }
                        }
                        if(flag)ans++;
                    }
                }
            }
            return ans;
        }

        class Point{
            int x;
            int y;
            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] g1 = new int[][]{{1,1,1,1,0,0}, {1, 1, 0, 1, 0, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 0}};
        int[][] g2 = new int[][]{{1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {1,
                1, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1}, {1, 0
                , 0, 1, 0, 0}};
        int ans = s.countSubIslands(g1,g2);
        System.out.println(ans);
    }
}
