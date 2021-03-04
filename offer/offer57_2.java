package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 */
public class offer57_2 {
    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 1;
        int n = 1;
        List<int[]> ls = new ArrayList<>();
        while (l < (target + 1) / 2) {
            if(n<target) {
                r++;
                n+=r;
            } else if(n>target) {
                n-=l;
                l++;
            } else {
                int[] tmp = new int[r-l+1];
                for(int i = l; i<=r; i++) {
                    tmp[i-l] = l;
                }
                ls.add(tmp);
                n-=l;
                l++;
            }
        }
        return ls.toArray(new int[ls.size()][]);
    }
}
