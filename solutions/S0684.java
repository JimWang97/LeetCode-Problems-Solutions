package solutions;

/**
 * 684. 冗余连接
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 * 示例 1：
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 */
public class S0684 {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int N = 0;
            for(int i = 0; i < edges.length; i++) {
                N = Math.max(N, edges[i][1]);
            }
            UnionFind uf = new UnionFind(N);
            for(int[] edge : edges) {
                if(!uf.isConnect(edge[0],edge[1])) {
                    uf.union(edge[0],edge[1]);
                } else {
                    return edge;
                }
            }
            return new int[]{};
        }

        class UnionFind {
            int[] parent;
            public UnionFind(int x) {
                parent = new int[x+1];
                for(int i = 0; i <= x; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if(parent[x]!=x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int rootx = find(x);
                int rooty = find(y);
                if(rootx==rooty) {
                    return;
                }
                parent[rootx] = rooty;
                return;
            }

            public boolean isConnect(int x, int y) {
                int rootx = find(x);
                int rooty = find(y);
                if(rootx==rooty) {
                    return true;
                }
                return false;
            }
        }
    }
}
