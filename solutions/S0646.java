package solutions;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 * 按照数对的第一位排序，然后逆序往前找数对的第二位小于当前数对的第一位时，dp[i]=max(dp[j]+1,dp[i])
 */
public class S0646 {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        if(len==0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.sort(pairs, (o1,o2)->o1[0]-o2[0]);
        Arrays.fill(dp, 1);
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < len; i++) {
            for(int j = i -1; j >=0; j--) {
                if(pairs[i][0]>pairs[j][1]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
