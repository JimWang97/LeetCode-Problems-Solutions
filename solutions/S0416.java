package solutions;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class S0416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        boolean[][] dp = new boolean[n][sum/2+1];
        if (nums[0] <= sum/2) {
            dp[0][nums[0]] = true;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= sum/2; j++) {
                dp[i][j] = dp[i-1][j];
                if(nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][sum/2];
    }
}
