package solutions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1027. 最长等差数列
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <=
 * i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 *
 * 等差数列如何转换成dp表示！！！
 */
public class S1027a {
    public int longestArithSeqLength(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i<len;i++) {
            Arrays.fill(dp[i], 2);
        }
        int ans = 2;
        for(int i = 0 ; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                int target = 2 * A[i] - A[j];
                if(map.containsKey(target)) {
                    dp[i][j] = dp[map.get(target)][i] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            map.put(A[i], i);
        }
        return ans;
    }
}
