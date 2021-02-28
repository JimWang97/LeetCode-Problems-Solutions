package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 1090. 受标签影响的最大值
 * 我们有一个项的集合，其中第 i 项的值为 values[i]，标签为 labels[i]。
 *
 * 我们从这些项中选出一个子集 S，这样一来：
 *
 * |S| <= num_wanted
 * 对于任意的标签 L，子集 S 中标签为 L 的项的数目总满足 <= use_limit。
 * 返回子集 S 的最大可能的 和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 *
 * 从最大的开始取，记录每个label的使用次数即可
 */
public class S1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int len = values.length;
        int[][] items = new int[len][2];
        for (int i = 0; i < len; ++i) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        Arrays.sort(items, Comparator.comparingInt(i -> -i[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] item : items) {
            int label_count = map.getOrDefault(item[1], 0);
            if (label_count < use_limit) {
                res += item[0];
                if (--num_wanted == 0)
                    break;
                map.put(item[1], label_count + 1);
            }
        }
        return res;
    }
}
