package solutions;

/**
 * 213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

 

示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class S0213 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[][][] dp = new int[nums.length][2][2];
        // 0代表不偷 1代表偷 只能偷1~N-1
        dp[0][0][0] = 0;
        dp[0][1][0] = nums[0];
        for(int i = 1; i < nums.length-1; i++) {
            dp[i][0][0] = Math.max(dp[i-1][1][0], dp[i-1][0][0]);
            dp[i][1][0] = dp[i-1][0][0]+nums[i];
        }
        
        // 偷2~N
        dp[1][0][1] = 0;
        dp[1][1][1] = nums[1];
        for(int i = 2; i < nums.length; i++) {
            dp[i][0][1] = Math.max(dp[i-1][1][1], dp[i-1][0][1]);
            dp[i][1][1] = dp[i-1][0][1]+nums[i];
        }
        return Math.max(Math.max(dp[nums.length-2][0][0],dp[nums.length-2][1][0]), Math.max(dp[nums.length-1][0][1], dp[nums.length-1][1][1]));
    }
}