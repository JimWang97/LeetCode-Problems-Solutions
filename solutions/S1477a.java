package solutions;

import java.util.Arrays;

/**
 * 1477. 找两个和为目标值且不重叠的子数组
 * 给你一个整数数组 arr 和一个整数值 target 。
 *
 * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 *
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,2,4,3], target = 3
 * 输出：2
 * 解释：只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
 */
public class S1477a {
    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length;
        int[] dp = new int [len];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0, j = 0; j < len; j++) {
            sum += arr[j];
            while(i<j && sum > target) {
                sum-=arr[i++];
            }
            if(sum==target) {
                dp[j] = j - i + 1;
                if(i != 0) {
                    ans = Math.min(ans, dp[i - 1] + j - i + 1);
                }
            }
            if(j!=0) {
                dp[j] = Math.min(dp[j], dp[j-1]);
            }
        }
        return ans > arr.length ? -1 : ans;
    }
}
