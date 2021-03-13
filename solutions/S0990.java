package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 */
public class S0990 {
    class Solution {
        public boolean equationsPossible(String[] equations) {
            List<String> nonEquation = new ArrayList<>();
            UnionFind uf = new UnionFind(26);
            for(String e : equations) {
                // 获取不等式，之后再判断
                if(e.contains("!")) {
                    nonEquation.add(e);
                } else {
                // 把等式通过并查集合并
                    uf.union(e.charAt(0), e.charAt(3));
                }
            }
            boolean ans = true;
            for(String ne : nonEquation) {
                ans &= !uf.isConnect(ne.charAt(0), ne.charAt(3));
            }
            return ans;
        }

        private class UnionFind{
            int[] parent;

            public UnionFind(int len) {
                parent = new int[len];
                for(int i = 0; i < len; i++) {
                    parent[i] = i;
                }
            }

            // 一边往上找，一边路径压缩
            public int find(int x) {
                if(parent[x]!=x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                x = x - 'a';
                y = y - 'a';
                int rootx = find(x);
                int rooty = find(y);
                if(rootx==rooty) {
                    return;
                }
                parent[rootx] = rooty;
            }

            public boolean isConnect(int x, int y) {
                x = x - 'a';
                y = y - 'a';
                int rootx = find(x);
                int rooty = find(y);
                if(rootx!=rooty) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}
