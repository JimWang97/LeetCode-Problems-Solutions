package solutions;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class S0088 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(n==0) return;
            int[] copy = new int[m];
            System.arraycopy(nums1,0,copy,0,m);
            int i = 0, j = 0;
            while(i<m&&j<n) {
                if(copy[i]<nums2[j]) {
                    nums1[i+j] = copy[i];
                    i++;
                } else {
                    nums1[i+j] = nums2[j];
                    j++;
                }
            }
            while(i<m) {
                nums1[i+j]=copy[i];
                i++;
            }
            while(j<n) {
                nums1[i+j]=nums2[j];
                j++;
            }
        }
    }
}
