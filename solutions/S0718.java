package solutions;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 */
public class S0718 {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA+1][lenB+1];
        int max = 0;
        for(int i = 1; i<= lenA; i++) {
            for(int j = 1; j <= lenB; j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
