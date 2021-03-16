package solutions;

import java.util.*;

/**
 * 1786. 从第一个节点出发到最后一个节点的受限路径数
 * 现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui
 * 和 vi 之间的边，这条边的权重为 weighti 。
 *
 * 从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和
 * zi+1 之间存在一条边。
 *
 * 路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 distanceToLastNode(zi) >
 * distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。
 *
 * 返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
 * 输出：3
 * 解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。三条受限路径分别是：
 * 1) 1 --> 2 --> 5
 * 2) 1 --> 2 --> 3 --> 5
 * 3) 1 --> 3 --> 5
 */
public class S1786b {
    class Solution {
        public int ans = 0;
        public int countRestrictedPaths(int n, int[][] edges) {
            // 预处理所有的边权。 a b w -> a : { b : w } + b : { a : w }
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int[] e : edges) {
                int a = e[0], b = e[1], w = e[2];
                Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<Integer, Integer>());
                am.put(b, w);
                map.put(a, am);
                Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<Integer, Integer>());
                bm.put(a, w);
                map.put(b, bm);
            }

            int[] min_dis = new int[n+1];
            boolean[] visited = new boolean[n+1];
            Arrays.fill(min_dis, Integer.MAX_VALUE);
            min_dis[n] = 0;
            PriorityQueue<int[]> q= new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
            q.offer(new int[]{n,0});
            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                int idx = tmp[0], dis = tmp[1];
                if(visited[idx]) continue;
                visited[idx] = true;
                Map<Integer, Integer> mmap = map.get(idx);
                if(mmap.isEmpty()) continue;
                for(int key : mmap.keySet()) {
                    if(!visited[key]) {
                        min_dis[key] = Math.min(min_dis[key], mmap.get(key) + min_dis[idx]);
                        q.add(new int[]{key, min_dis[key]});
                    }
                }
            }

            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                arr[i] = new int[]{i+1, min_dis[i+1]};
            }
            Arrays.sort(arr, (o1, o2) -> o1[1]-o2[1]);

            int[] f = new int[n+1];
            f[n] = 1;
            for(int i = 0; i < n; i++) {
                int idx = arr[i][0], dis = arr[i][1];
                Map<Integer, Integer> mmap = map.get(idx);
                for(int key : mmap.keySet()) {
                    if(dis > min_dis[key]) {
                        f[idx] += f[key];
                        f[idx] %= 1000000007;
                    }
                }
                if(idx==1) break;
            }
            return f[1];

//            dfs(n, 1, min_dis, map, 0);
        }

        public void dfs(int start, int end, int[] dis, Map<Integer, Map<Integer, Integer>> map, int pre_dis) {
            if(start==end) {
                ans++;
                return;
            }
            Map<Integer, Integer> mmap = map.get(start);
            for(int key : mmap.keySet()) {
                if(dis[key]>pre_dis) {
                    dfs(key, end, dis, map, dis[key]);
                }
            }
        }
    }
}
