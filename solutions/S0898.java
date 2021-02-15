package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 898. 子数组按位或操作
 * 我们有一个非负整数数组 A。
 *
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 *
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0]
 * 输出：1
 * 解释：
 * 只有一个可能的结果 0 。
 *
 * 用set来获取不重复值
 */
public class S0898 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x: A) {
            Set<Integer> cur2 = new HashSet();
            for (int y: cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}
