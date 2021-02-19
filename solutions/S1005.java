package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1005. K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 */
public class S1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->o1-o2);
        for(int a : A) {
            q.offer(a);
        }
        while(K>0) {
            int tmp = q.poll();
            tmp = -tmp;
            q.offer(tmp);
            K--;
        }
        int ans = 0;
        for(int i : q) {
            ans+=i;
        }
        return ans;
    }
}
