package solutions;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * 使用回溯，用一个used数组来记录已经用过的，然后多次寻找sum/k就可以了
 */
public class S0698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int total = 0;
        for(int i : nums) {
            total += i;
        }
        if(total%k!=0) {
            return false;
        }
        Arrays.sort(nums);
        if(nums[len-1]>total/k) {
            return false;
        }
        boolean[] used = new boolean[len];
        return backtracking(nums, k, total/k, 0, 0, used);
    }
    public boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        if (k==0) {
            return true;
        }
        if(cur == target) {
            return backtracking(nums, k-1, target, 0, 0, used);
        }
        for(int i = start; i < nums.length; i++) {
            if(!used[i] && cur+nums[i]<=target) {
                used[i] = true;
                if(backtracking(nums, k, target, cur+nums[i], i+1, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
