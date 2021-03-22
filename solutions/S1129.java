package solutions;

import java.util.*;

/**
 * 1129. 颜色交替的最短路径
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 *
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 *
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 */
public class S1129 {
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
            Map<Integer, Set<Integer>> graph_red = new HashMap<>();
            Map<Integer, Set<Integer>> graph_blue = new HashMap<>();
            for(int i = 0; i < n; i++) {
                graph_red.put(i, new HashSet<>());
                graph_blue.put(i, new HashSet<>());
            }
            for(int[] edge : red_edges) {
                graph_red.get(edge[0]).add(edge[1]);
            }
            for(int[] edge : blue_edges) {
                graph_blue.get(edge[0]).add(edge[1]);
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            int[] redans = new int[n];
            int[] blueans = new int[n];
            Arrays.fill(redans, Integer.MAX_VALUE);
            Arrays.fill(blueans, Integer.MAX_VALUE);
            int color = 1;
            int dis = 0;
            while(!q.isEmpty()) {
                int sz = q.size();
                dis++;
                for(int i = 0; i < sz; i++) {
                    int pre = q.poll();
                    if(color==1) {
                        Set<Integer> nexts = graph_red.get(pre);
                        if(nexts==null) continue;
                        for(int next : nexts) {
                            if(redans[next]==Integer.MAX_VALUE||redans[next]>dis){
                                q.offer(next);
                                redans[next] = Math.min(redans[next], dis);
                            }
                        }
                    } else {
                        Set<Integer> nexts = graph_blue.get(pre);
                        if(nexts==null) continue;
                        for(int next : nexts) {
                            if(blueans[next]==Integer.MAX_VALUE||blueans[next]>dis){
                                q.offer(next);
                                blueans[next] = Math.min(blueans[next], dis);
                            }
                        }
                    }
                }
                color = -color;
            }
            color = -1;
            dis = 0;
            q.offer(0);
            while(!q.isEmpty()) {
                int sz = q.size();
                dis++;
                for(int i = 0; i < sz; i++) {
                    int pre = q.poll();
                    if(color==1) {
                        Set<Integer> nexts = graph_red.get(pre);
                        if(nexts==null) continue;
                        for(int next : nexts) {
                            if(redans[next]==Integer.MAX_VALUE||redans[next]>dis){
                                q.offer(next);
                                redans[next] = Math.min(redans[next], dis);
                            }
                        }
                    } else {
                        Set<Integer> nexts = graph_blue.get(pre);
                        if(nexts==null) continue;
                        for(int next : nexts) {
                            if(blueans[next]==Integer.MAX_VALUE||blueans[next]>dis){
                                q.offer(next);
                                blueans[next] = Math.min(blueans[next], dis);
                            }
                        }
                    }
                }
                color = -color;
            }
            int[] ans = new int[n];
            for(int i = 0; i < n; i++) {
                ans[i] = Math.min(redans[i], blueans[i]);
                if(ans[i]==Integer.MAX_VALUE) {
                    ans[i] = -1;
                }
            }
            ans[0] = 0;
            return ans;
        }
    }
}
