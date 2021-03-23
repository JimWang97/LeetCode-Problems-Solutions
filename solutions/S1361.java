package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1361. 验证二叉树
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 *
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 *
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 *
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 */
public class S1361 {
    class Solution {
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            UnionFind uf = new UnionFind(n);
            for(int i = 0; i < n; i++) {
                if(leftChild[i]!=-1) {
                    if(uf.isConnect(leftChild[i],i)||uf.find(leftChild[i])!=leftChild[i]) {
                        return false;
                    }
                    uf.union(leftChild[i],i);
                }
                if(rightChild[i]!=-1) {
                    if(uf.isConnect(rightChild[i],i)||uf.find(rightChild[i])!=rightChild[i]) {
                        return false;
                    }
                    uf.union(rightChild[i],i);
                }
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                int p = uf.find(i);
                if(uf.getSz(p)!=1) {
                    set.add(p);
                }
            }
            return set.size()<=1?true:false;
        }

        class UnionFind{
            int[] parent;
            int[] sz;
            public UnionFind(int num) {
                parent = new int[num];
                sz = new int[num];
                for(int i = 0; i < num; i++) {
                    parent[i] = i;
                    sz[i] =1;
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
                if(rootx!=rooty) {
                    parent[rootx] = rooty;
                    sz[rooty]++;
                }
            }

            public boolean isConnect(int x, int y) {
                int rootx = find(x);
                int rooty = find(y);
                if(rootx!=rooty) {
                    return false;
                }
                return true;
            }

            public int getSz(int x) {
                return sz[find(x)];
            }
        }
    }
}
