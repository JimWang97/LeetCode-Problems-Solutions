package solutions;

import java.util.*;

/**
 * 面试题 04.01. 节点间通路
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 示例2:
 *
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0,
 *  target = 4
 *  输出 true
 */
public class interview_04_01 {
    class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int[] p : graph){
                if(!map.containsKey(p[0])){
                    map.put(p[0], new ArrayList<>());
                }
                map.get(p[0]).add(p[1]);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()) {
                int sz = queue.size();
                for(int i = 0; i < sz; i++) {
                    int st = queue.poll();
                    List<Integer> ls = map.get(st);
                    if(ls==null) {
                        continue;
                    }
                    for(int num : ls) {
                        if(num==target) {
                            return true;
                        } else {
                            queue.add(num);
                        }
                    }
                    // 删除环，避免死循环
                    map.put(st, null);
                }
            }
            return false;
        }
    }
}
