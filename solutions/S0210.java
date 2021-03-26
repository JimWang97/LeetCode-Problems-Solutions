package solutions;

import java.util.*;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 */
public class S0210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for(int[] prerequest : prerequisites) {
                Set<Integer> edge = graph.getOrDefault(prerequest[1], new HashSet<>());
                edge.add(prerequest[0]);
                graph.put(prerequest[1],edge);
                indegrees[prerequest[0]]++;
            }
            Queue<Integer> q = new LinkedList<>();
            int idx = 0;
            int[] ans = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                if(indegrees[i]==0) {
                    q.add(i);
                    ans[idx]=i;
                    idx++;
                }
            }

            while(!q.isEmpty()) {
                int tmp = q.poll();
                Set<Integer> nexts = graph.get(tmp);
                if(nexts==null) continue;
                for(int next : nexts) {
                    indegrees[next]--;
                    if(indegrees[next]==0) {
                        q.add(next);
                        ans[idx]=next;
                        idx++;
                    }
                }
            }
            return idx==numCourses?ans:new int[]{};
        }
    }
}
