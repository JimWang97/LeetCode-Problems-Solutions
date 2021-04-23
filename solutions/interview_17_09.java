package solutions;

/**
 * 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 */
public class interview_17_09 {
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] dp = new int[k];
            dp[0] = 1;
            int num3 = 0, num5 = 0, num7 = 0;
            for(int i = 1; i < k; i++) {
                int n3 = 3*dp[num3];
                int n5 = 5*dp[num5];
                int n7 = 7*dp[num7];
                int min = Math.min(Math.min(n3,n5),n7);
                dp[i] = min;
                if(min==n3) num3++;
                if(min==n5) num5++;
                if(min==n7) num7++;
            }
            return dp[k-1];
        }
    }
}
