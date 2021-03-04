package offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class offer53 {

    public int count = 0;
    public int search(int[] nums, int target) {
        helper(0, nums.length-1, target, nums);
        return count;
    }

    private void helper(int left, int right, int target, int[] nums) {
        if(left > right) {
            return;
        }
        int mid = left + (right-left)/2;
        if(nums[mid] == target) {
            count++;
            helper(left, mid-1, target, nums);
            helper(mid+1, right, target, nums);
        } else if (nums[mid] < target) {
            helper(mid+1, right, target, nums);
        } else {
            helper(left, mid-1, target, nums);
        }
    }
}
