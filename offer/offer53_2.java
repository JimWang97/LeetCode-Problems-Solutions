package offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 */
public class offer53_2 {

    public int ans;
    public int missingNumber(int[] nums) {
        ans = nums.length;
        helper(0, nums.length-1, nums);
        return ans;
    }

    private void helper(int left, int right, int[] nums) {
        if(left>right) {
            return;
        }
        int mid = left + (right-left) / 2;
        if(nums[mid] != mid) {
            ans = mid;
            helper(left, mid-1, nums);
        } else {
            helper(mid+1, right, nums);
        }
    }
}
