package solutions;

/**
 * 1267. 统计参与通信的服务器
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 */
public class S1267 {
    class Solution {
        public int countServers(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int[] num_row = new int[rows];
            int[] num_col = new int[cols];
            for(int i = 0; i < rows;i++) {
                for(int j = 0; j < cols;j++) {
                    if(grid[i][j]==1) {
                        num_row[i]++;
                        num_col[j]++;
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < rows;i++) {
                for(int j = 0; j < cols;j++) {
                    if(grid[i][j]==1 && (num_row[i]>1 || num_col[j]>1)) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
