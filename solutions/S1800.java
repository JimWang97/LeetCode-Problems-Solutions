package solutions;

/**
 * 1800. 最大升序子数组和
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * 子数组是数组中的一个连续数字序列。
 *
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1
 * 的子数组也视作 升序 子数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65
 */
public class S1800 {
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int sum = nums[0];
            int ans = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(nums[i]>nums[i-1]) {
                    sum+=nums[i];
                } else {
                    ans = Math.max(ans, sum);
                    sum = nums[i];
                }
            }
            ans = Math.max(ans, sum);
            return ans;
        }
    }
}
