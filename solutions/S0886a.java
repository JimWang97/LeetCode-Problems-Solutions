package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 886. 可能的二分法
 * 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 *
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 *
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 *
 * 染色算法
 */
public class S0886a {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] dislike : dislikes) {
            List<Integer> dislike1 = map.get(dislike[0]);
            dislike1.add(dislike[1]);
            List<Integer> dislike2 = map.get(dislike[1]);
            dislike2.add(dislike[0]);
        }
        int[] color = new int[N+1];
        for(int i = 1; i <= N; i++) {
            // 未染色，且染色失败就返回false
            if(color[i]==0 && !dfs(color, 1, i, map)) return false;
        }
        return true;
    }
    public boolean dfs(int[] color, int c, int i, Map<Integer, List<Integer>> map) {
        color[i] = c;
        for(int idx : map.get(i)) {
            if(color[idx]==c) return false;
            if(color[idx]==0 && !dfs(color, -c, idx, map)) return false;
        }
        return true;
    }
}
