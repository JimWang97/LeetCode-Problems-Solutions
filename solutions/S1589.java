package solutions;

import java.util.Arrays;

/**
 * 1589. 所有排列中的最大和
 * 有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums[starti] + nums[starti + 1] + ... +
 * nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
 *
 * 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。
 *
 * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
 * 输出：19
 * 解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
 * 总和为：8 + 3 = 11。
 * 一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
 * 总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
 */
public class S1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int len = nums.length;
        int[] counts = new int[len];
        for (int[] request : requests) {
            int start = request[0], end = request[1];
            counts[start]++;
            if (end + 1 < len) {
                counts[end + 1]--;
            }
        }
        for (int i = 1; i < len; i++) {
            counts[i] += counts[i - 1];
        }
        Arrays.sort(counts);
        Arrays.sort(nums);
        long ans = 0;
        for (int i = len - 1; i >= 0 && counts[i] > 0; i--) {
            ans += (long) nums[i] * counts[i];
        }
        return (int)(ans % 1000000007);
    }
}
