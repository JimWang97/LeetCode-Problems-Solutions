package offer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class offer21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int i = 0, j = len-1;
        while(i<j) {
            while(i < len && nums[i]%2==1) {
                i++;
            }
            while(j >=0&&nums[j]%2==0) {
                j--;
            }
            if(i<len&&j>=0&&i<j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            i++;
            j--;
        }
        return nums;
    }
}
