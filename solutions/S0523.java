package solutions;

/**
 * 523. 连续的子数组和
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 */
public class S0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        for(int i = 0 ; i <len; i++) {
            dp[i] = nums[i];
            for(int j = i+1; j<len; j++) {
                dp[j] = dp[j-1] + nums[j];
                if(k!=0){
                    if(dp[j]%k==0) {
                        return true;
                    }
                } else {
                    if(dp[j]==0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
