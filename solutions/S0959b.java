package solutions;

/**
 * 959. 由斜杠划分区域
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 */
public class S0959b {
    class Solution {
        public int regionsBySlashes(String[] grid) {
            int N = grid.length;
            UnionFind uf = new UnionFind(4*N*N);
            for(int i = 0; i < N; i++) {
                char[] row = grid[i].toCharArray();
                for(int j = 0; j < N; j++) {
                    int idx = 4*(i*N+j);
                    char c = row[j];
                    if(c=='/') {
                        uf.union(idx, idx+3);
                        uf.union(idx+1, idx+2);
                    } else if(c=='\\') {
                        uf.union(idx, idx+1);
                        uf.union(idx+2, idx+3);
                    } else {
                        uf.union(idx, idx+1);
                        uf.union(idx+1, idx+2);
                        uf.union(idx+2, idx+3);
                    }
                    // 单元格间合并
                    // 向右合并：1（当前）、3（右一列）
                    if (j + 1 < N) {
                        uf.union(idx + 1, 4 * (i * N + j + 1) + 3);
                    }
                    // 向下合并：2（当前）、0（下一行）
                    if (i + 1 < N) {
                        uf.union(idx + 2, 4 * ((i + 1) * N + j));
                    }
                }
            }
            return uf.getCount();
        }

        class UnionFind {
            int[] parent;
            int count;

            public UnionFind(int num) {
                this.count = num;
                parent = new int[num];
                for(int i = 0; i < num; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if(parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y){
                int rootx = find(x);
                int rooty = find(y);
                if(rootx!=rooty) {
                    parent[rootx] = rooty;
                    count--;
                }
            }

            public int getCount() {
                return count;
            }
        }
    }
}
