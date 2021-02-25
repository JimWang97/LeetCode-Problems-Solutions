package solutions;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *
 * 请你返回乘积为正数的最长子数组长度。
 *
 *
 *
 * 示例  1：
 *
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 */
public class S1567a {
    public int getMaxLen(int[] nums) {
        int ans = 0, pos = 0, neg = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==0) {
                pos = 0;
                neg = Integer.MIN_VALUE;
            } else if(nums[i]<0) {
                int tmp = neg;
                neg = pos+1;
                pos = Math.max(tmp+1, 0);
            } else {
                pos = pos+1;
                neg = neg+1;
            }
            ans = Math.max(ans, pos);
        }
        return ans;
    }
}
