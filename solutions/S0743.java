package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 */
public class S0743 {
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
            for(int[] time : times) {
                int from = time[0], to = time[1], t = time[2];
                Map<Integer, Integer> edge = graph.getOrDefault(from, new HashMap<Integer, Integer>());
                edge.put(to, t);
                graph.put(from, edge);
            }

            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
            q.offer(new int[]{k,0});
            boolean[] visited = new boolean[n+1];
            int[] min_dis = new int[n+1];
            Arrays.fill(min_dis, Integer.MAX_VALUE);
            min_dis[k] = 0;
            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                int node = tmp[0];
                int t = tmp[1];
                if(visited[node]) continue;
                visited[node] = true;
                Map<Integer, Integer> nexts = graph.get(node);
                if(nexts==null) continue;
                for(int key : nexts.keySet()) {
                    if(!visited[key]) {
                        min_dis[key] = Math.min(min_dis[key], t+nexts.get(key));
                        q.add(new int[]{key, min_dis[key]});
                    }
                }
            }
            int ans = 0;
            for(int i = 1; i <= n; i++) {
                if(min_dis[i]==Integer.MAX_VALUE) {
                    return -1;
                }
                ans=Math.max(min_dis[i],ans);
            }
            return ans;
        }
    }
}
