package solutions;

/**
 * 1458. 两个子序列的最大点积
 * 给你两个数组 nums1 和 nums2 。
 *
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 *
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 */
public class S1458b {
        public static int maxDotProduct(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int[][] dp = new int[len1][len2];

            for(int i = 0; i < len1; i++) {
                for(int j = 0; j < len2; j++) {
                    int xij = nums1[i]*nums2[j];
                    dp[i][j] = xij;
                    if(i>0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    }
                    if(j>0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                    }
                    if(i>0&&j>0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+xij);
                    }
                }
            }
            return dp[len1-1][len2-1];
        }

    public static void main(String[] args) {
        maxDotProduct(new int[]{2,1,-2,5}, new int[]{3,0,-6});
    }
}
