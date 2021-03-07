package solutions;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 */
public class S0153 {
    public int findMin(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i]<nums[i-1]) {
                return nums[i];
            }
        }
        return ans;
    }
}
