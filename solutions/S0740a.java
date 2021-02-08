package solutions;

import java.util.Arrays;

/**
 * 740. 删除与获得点数
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释:
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 */
public class S0740a {
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if(len==0) {
            return 0;
        } else if(len==1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int[] dp = new int[nums[len-1]];
        dp[0] = 0;
        int[] all = new int[nums[len-1]];
        for(int item:nums) {
            all[item]++;
        }
        dp[1] = all[1]*1;
        dp[2] = Math.max(dp[1],all[2] * 2);
        for(int i = 2;i<=nums[len-1];i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+all[i]*i);
        }
        return dp[nums[len-1]];
    }
}
