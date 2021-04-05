package solutions;

/**
 * 1537. 最大得分
 * 你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。
 *
 * 一条 合法路径 定义如下：
 *
 * 选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
 * 从左到右遍历当前数组。
 * 如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
 * 得分定义为合法路径中不同数字的和。
 *
 * 请你返回所有可能合法路径中的最大得分。
 *
 * 由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
 * 输出：30
 * 解释：合法路径包括：
 * [2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],（从 nums1 开始遍历）
 * [4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]  （从 nums2 开始遍历）
 * 最大得分为上图中的绿色路径 [2,4,6,8,10] 。
 */
public class S1537a {
    class Solution {
        public int maxSum(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length;
            long best1=0, best2=0;
            int i = 0, j = 0;
            while(i<len1||j<len2) {
                if(i<len1&&j<len2) {
                    if(nums1[i]<nums2[j]) {
                        best1+=nums1[i];
                        i++;
                    } else if(nums1[i]>nums2[j]) {
                        best2+=nums2[j];
                        j++;
                    } else {
                        long best = Math.max(best1, best2) + nums1[i];
                        best1 = best;
                        best2 = best;
                        i++;
                        j++;
                    }
                } else if(i<len1) {
                    best1+=nums1[i];
                    i++;
                } else if(j<len2) {
                    best2+=nums2[j];
                    j++;
                }
            }
            return (int) (Math.max(best1,best2)%1000000007);
        }
    }
}
