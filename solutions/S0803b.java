package solutions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 803. 打砖块
 * 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
 *
 * 一块砖直接连接到网格的顶部，或者
 * 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
 * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli)
 * 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
 *
 * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
 *
 * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
 * 输出：[2]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0]，
 *  [1,1,1,0]]
 * 消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0]
 *  [0,1,1,0]]
 * 两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
 * [[1,0,0,0],
 *  [0,0,0,0]]
 * 因此，结果为 [2] 。
 */
public class S0803b {
    private int row;
    private int col;
    public static final int[][] DIRECTIONS = {{0,1},{1,0},{-1,0},{0,-1}};
    public  int[] hitBricks(int[][] grid, int[][] hits) {
        this.row = grid.length;
        this.col = grid[0].length;

        int[][] copy = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        for(int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        int sz = row*col;
        UnionFind unionFind = new UnionFind(sz+1);

        for(int j = 0; j < col; j++) {
            if(copy[0][j]==1) {
                unionFind.union(j, sz);
            }
        }

        for(int i = 1; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(copy[i][j]==1) {
                    if(copy[i-1][j]==1) {
                        unionFind.union(getIndex(i-1,j), getIndex(i,j));
                    }
                    if(j>0&&copy[i][j-1]==1) {
                        unionFind.union(getIndex(i,j-1), getIndex(i,j));;
                    }
                }
            }
        }

        int hitsLen = hits.length;
        int[] res = new int[hitsLen];
        for(int i = hitsLen -1;i>=0;i--) {
            int x = hits[i][0];
            int y = hits[i][1];

            if(grid[x][y]==0) {
                continue;
            }
            // 补回之前与屋顶相连的砖块数
            int origin = unionFind.getSize(sz);

            // 注意：如果补回的这个结点在第 1 行，要告诉并查集它与屋顶相连（逻辑同第 2 步）
            if (x == 0) {
                unionFind.union(y, sz);
            }

            // 在 4 个方向上看一下，如果相邻的 4 个方向有砖块，合并它们
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (inArea(newX, newY) && copy[newX][newY] == 1) {
                    unionFind.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            // 补回之后与屋顶相连的砖块数
            int current = unionFind.getSize(sz);
            // 减去的 1 是逆向补回的砖块（正向移除的砖块），与 0 比较大小，是因为存在一种情况，添加当前砖块，不会使得与屋顶连接的砖块数更多
            res[i] = Math.max(0, current - origin - 1);

            // 真正补上这个砖块
            copy[x][y] = 1;
        }
        return res;
    }
    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    /**
     * 二维坐标转换为一维坐标
     *
     * @param x
     * @param y
     * @return
     */
    private int getIndex(int x, int y) {
        return x * col + y;
    }
    private class UnionFind {
        private int[] parent;
        private int[] size;
        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i]=i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if(parent[x]!=x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX==rootY) {
                return;
            }
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }

        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }
}
