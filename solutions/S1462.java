package solutions;

import java.util.*;

/**
 * 1462. 课程表 IV
 * 你总共需要上 n 门课，课程编号依次为 0 到 n-1 。
 *
 * 有的课会有直接的先修课程，比如如果想上课程 0 ，你必须先上课程 1 ，那么会以 [1,0] 数对的形式给出先修课程数对。
 *
 * 给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。
 *
 * 对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。
 *
 * 请返回一个布尔值列表，列表中每个元素依次分别对应 queries 每个查询对的判断结果。
 *
 * 注意：如果课程 a 是课程 b 的先修课程且课程 b 是课程 c 的先修课程，那么课程 a 也是课程 c 的先修课程。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * 输出：[false,true]
 * 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
 */
public class S1462 {
    class Solution {
        public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            boolean[][] isRequest = new boolean[n][n];
            // 存储先修课程，和后续课程链表
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
            // 邻接表
            for(int[] request : prerequisites) {
                List<Integer> ls = map.get(request[0]);
                ls.add(request[1]);
            }

            for(int i = 0; i < n; i++) {
                bfs(i, map, isRequest, n);
            }

            List<Boolean> ans = new ArrayList<>();
            for(int[] query : queries) {
                if(isRequest[query[0]][query[1]]) {
                    ans.add(true);
                } else {
                    ans.add(false);
                }
            }
            return ans;
        }

        public void bfs(int pre, Map<Integer, List<Integer>> map, boolean[][] isRequest, int n) {
            List<Integer> ls = map.get(pre);
            if(ls.isEmpty()) {
                return;
            }
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(pre);
            while(!queue.isEmpty()) {
                List<Integer> tls = map.get(queue.poll());
                for(int next : tls) {
                    if(!visited[next]){
                        isRequest[pre][next] = true;
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
