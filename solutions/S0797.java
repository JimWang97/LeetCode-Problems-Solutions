package solutions;

import java.util.List;
import java.util.ArrayList;

/**
 * 797. 所有可能的路径 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * 
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a
 * ）空就是没有下一个结点了。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：graph = [[1,2],[3],[3],[]] 输出：[[0,1,3],[0,2,3]] 解释：有两条路径 0 -> 1 -> 3 和 0
 * -> 2 -> 3
 */
public class S0797 {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        helper(0, graph, new ArrayList<Integer>());
        return ans;
    }

    public void helper(int curNode, int[][] graph, List<Integer> ls){
        if(curNode == graph.length-1){
            ls.add(curNode);
            ans.add(new ArrayList<Integer>(ls));
            ls.remove(ls.size()-1);
            return;
        }
        int[] path = graph[curNode];
        for(int i : path){
            ls.add(curNode);
            helper(i, graph, ls);
            ls.remove(ls.size()-1);
        }

    }
}