package solutions;

/**
 * 1262. 可被三整除的最大和
给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。

 

示例 1：

输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 */
public class S1262 {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int [nums.length+1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++) {
            int mod = nums[i-1] % 3;
            if(mod == 1) {
                dp[i][0] = Math.max(dp[i-1][2]+nums[i-1], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][0]+nums[i-1], dp[i-1][1]);
                dp[i][2] = Math.max(dp[i-1][1]+nums[i-1], dp[i-1][2]);
            } else if(mod == 2) {
                dp[i][0] = Math.max(dp[i-1][1]+nums[i-1], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][2]+nums[i-1], dp[i-1][1]);
                dp[i][2] = Math.max(dp[i-1][0]+nums[i-1], dp[i-1][2]);
            } else {
                dp[i][0] = dp[i-1][0]+nums[i-1];
                dp[i][1] = dp[i-1][1]+nums[i-1];
                dp[i][2] = dp[i-1][2]+nums[i-1];
            }
            
        }
        return dp[nums.length][0];
    }
}