package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1615. 最大网络秩
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 *
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 *
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 *
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 */
public class S1615 {
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] rank = new int[n];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
            for(int[] road : roads) {
                rank[road[0]]++;
                rank[road[1]]++;
                List<Integer> ls = map.get(road[0]);
                ls.add(road[1]);
                List<Integer> ls1 = map.get(road[1]);
                ls1.add(road[0]);
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n;i++) {
                for(int j = i+1; j <n;j++) {
                    List<Integer> l = map.getOrDefault(i, new ArrayList<>());
                    if(l.contains(j)) {
                        max=Math.max(max, rank[i]+rank[j]-1);
                    } else {
                        max=Math.max(max, rank[i]+rank[j]);
                    }
                }
            }
            return max;
        }
    }
}