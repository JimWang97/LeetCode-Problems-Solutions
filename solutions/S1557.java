package solutions;

import java.util.*;

/**
 * 1557. 可以到达所有点的最少点数目
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 *
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 *
 * 你可以以任意顺序返回这些节点编号。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * 输出：[0,3]
 * 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
 */
public class S1557 {
    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            int[] outdegrees = new int[n];
            int[] indegrees = new int[n];
            int sz = edges.size();
            // 记录哪些节点有指向该节点的边
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0;i < n; i++) {
                map.put(i, new ArrayList());
            }
            for(int i = 0; i < sz; i++) {
                outdegrees[edges.get(i).get(0)]++;
                indegrees[edges.get(i).get(1)]++;
                List<Integer> tmp = map.get(edges.get(i).get(1));
                tmp.add(edges.get(i).get(0));
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                if(outdegrees[i]==0 && indegrees[i]>0) {
                    q.add(i);
                }
            }
            while(!q.isEmpty()) {
                int node = q.poll();
                indegrees[node]=-1;
                List<Integer> pres = map.get(node);
                if(pres==null) continue;
                for(int pre : pres) {
                    outdegrees[pre]--;
                    if(outdegrees[pre]==0&& indegrees[pre]>0) {
                        q.add(pre);
                    }
                }
            }
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(indegrees[i]>=0) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
