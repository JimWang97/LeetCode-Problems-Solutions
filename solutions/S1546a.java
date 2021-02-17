package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1546. 和为目标值的最大数目不重叠非空子数组数目
 * 给你一个数组 nums 和一个整数 target 。
 *
 * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 2
 * 输出：2
 * 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
 */
public class S1546a {
    public int maxNonOverlapping(int[] nums, int target) {
        int len = nums.length;
        int ans = 0;
        int i = 0;
        while(i<len) {
            Set<Integer> set = new HashSet<Integer>(){{
                add(0);
            }};
            int sum = 0;
            while(i<len) {
                sum+=nums[i];
                if(set.contains(sum-target)) {
                    ans++;
                    break;
                } else {
                    set.add(sum);
                    i++;
                }
            }
            i++;
        }
        return ans;
    }
}
