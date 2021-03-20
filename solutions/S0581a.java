package solutions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 从左往右遍历，找到一个数小于左侧的最大值时j，向左遍历，找到它该放入的位置i。那么j-i就是这个数组的距离。i取每次的最小值，j取最大值。
 */
public class S0581a {
    public int findUnsortedSubarray(int[] nums) {
        int i = nums.length, j = 0, max_pre = nums[0];
        for(int k = 1; k <nums.length; k++) {
            if(nums[k]>max_pre) {
                i = Math.min(i,k-1);
                while(i>=0 &&nums[i]>nums[k]) i--;
                j = k;
            }
            else {
                max_pre = nums[k];
            }
        }
        return i>j?0:j-i;
    }
}
