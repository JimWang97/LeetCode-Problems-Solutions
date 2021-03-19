package solutions;

import java.util.*;

/**
 * 1514. 概率最大的路径
 * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 *
 * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 *
 * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * 输出：0.25000
 * 解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
 */
public class S1514 {
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            if (n == 0) {
                return 0;
            }

            List<List<int[]>> G = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                G.add(new ArrayList<>());
            }

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                G.get(edge[0]).add(new int[]{i, edge[1]});
                G.get(edge[1]).add(new int[]{i, edge[0]});
            }

            double[] probs = new double[n];
            Queue<Integer> Q = new LinkedList<>();
            probs[start] = 1;
            Q.offer(start);

            while(!Q.isEmpty()) {
                int sz = Q.size();
                Set<Integer> set = new HashSet<>();
                for(int i = 0; i < sz; i++) {
                    int pre = Q.poll();
                    if(pre==end) {
                        continue;
                    }
                    for(int[] next : G.get(pre)) {
                        double nextProb = probs[pre] * succProb[next[0]];
                        if (nextProb > probs[next[1]]) {
                            probs[next[1]] = nextProb;
                            set.add(next[1]);
                        }
                    }
                }
                for(int i : set) {
                    Q.add(i);
                }
            }
            return probs[end];
        }
    }
}
