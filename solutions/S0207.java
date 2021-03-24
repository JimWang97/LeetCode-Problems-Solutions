package solutions;

import java.util.*;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 */
public class S0207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegree = new int[numCourses];
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for(int[] pre : prerequisites) {
                indegree[pre[1]]++;
                Set<Integer> set = graph.getOrDefault(pre[0], new HashSet<>());
                set.add(pre[1]);
                graph.put(pre[0],set);
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < numCourses; i++) {
                if(indegree[i]==0) {
                    q.offer(i);
                }
            }
            while(!q.isEmpty()) {
                int pre = q.poll();
                Set<Integer> nexts = graph.get(pre);
                if(nexts==null) continue;
                for(int next : nexts) {
                    indegree[next]--;
                    if(indegree[next]==0) {
                        q.offer(next);
                    }
                }
            }
            for(int i = 0; i < numCourses; i++) {
                if(indegree[i]>0) {
                    return false;
                }
            }
            return true;
        }
    }
}
