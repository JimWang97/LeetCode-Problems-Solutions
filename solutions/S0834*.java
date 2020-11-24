package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 834. Sum of Distances in Tree
An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.

The ith edge connects nodes edges[i][0] and edges[i][1] together.

Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

Example 1:

Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 */
public class S0834 {
    // 公式：以上图为例 ans(2) = ans(0) + 0及其左侧子节点个数 - 2即2的子节点个数
    public int[] count, ans; //count 每个点的子节点+自己的个数
    public List<Set<Integer>> tree;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        int len = edges.length;
        count = new int[N];
        Arrays.fill(count, 1);
        ans = new int[N];
        if(len<1) return ans;
        tree = new ArrayList<Set<Integer>>();
        for(int i = 0; i < N; i++){
            tree.add(new HashSet<Integer>());
        }
        for(int i =0;i<len;i++){
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }

        dfs(0, -1);
        dfs2(0,-1);
        return ans;
    }

    // 统计每个节点下面的子节点数。ans为了求root到其他点的距离之和
    public void dfs(int cur, int parent){
        for(int child:tree.get(cur)){
            if(child!=parent){
                dfs(child,cur);
                count[cur]+=count[child];
                ans[cur]+=ans[child]+count[child];
            }
        }
    }

    public void dfs2(int cur, int parent){
        for(int child:tree.get(cur)){
            if(child!=parent){
                ans[child] = ans[cur]+(N-count[child])-count[child];
                dfs2(child,cur);
            }
        }
    }




}