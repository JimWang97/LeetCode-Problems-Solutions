package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1443. 收集树上所有苹果的最少时间 给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费
 * 1 秒钟。你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 * 
 * 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi
 * 。除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,true,true,false] 输出：8
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 */
public class S1443 {
    public void buildReverseEdges(List<List<Integer>> nodeMap, int val) {
        for (int pairVal : nodeMap.get(val)) {
            if (pairVal != 0 && reverseEdges[pairVal] == -1) {
                reverseEdges[pairVal] = val;
                buildReverseEdges(nodeMap, pairVal);
            }
        }
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> nodeMap = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodeMap.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }
        reverseEdges = new int[n];
        Arrays.fill(reverseEdges, -1);
        //这一步建了一颗以0为根节点的树，确保能通过子结点找到父结点，父结点记录在reverseEdges数组中
        buildReverseEdges(nodeMap, 0);
        visited = new boolean[n];
        visited[0] = true;

        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                dfsEdge(i);
            }
        }
        return ans * 2;
    }

    int ans = 0;
    int[] reverseEdges;
    boolean[] visited;

    public void dfsEdge(int to) {
        if (!visited[to]) {
            visited[to] = true;
            ans++;
            dfsEdge(reverseEdges[to]);
        }
    }
}