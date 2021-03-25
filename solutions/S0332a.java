package solutions;

import java.util.*;

/**
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 *
 *
 * 提示：
 *
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *
 *
 * 示例 1：
 *
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 */
public class S0332a {
    class Solution {
        List<String> ans = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph;
        public List<String> findItinerary(List<List<String>> tickets) {
            graph = new HashMap<>();
            for(List<String> ticket : tickets) {
                String src = ticket.get(0), dst = ticket.get(1);
                if (!graph.containsKey(src)) {
                    graph.put(src, new PriorityQueue<String>());
                }
                graph.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(ans);
            return ans;
        }

        private void dfs(String src) {
            while(graph.containsKey(src) && graph.get(src).size()!=0) {
                String tmp = graph.get(src).poll();
                dfs(tmp);
            }
            ans.add(src);
        }


    }
}
