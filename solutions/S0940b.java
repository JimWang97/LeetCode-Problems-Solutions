package solutions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 940. 不同的子序列 II
 * 给定一个字符串 S，计算 S 的不同非空子序列的个数。
 *
 * 因为结果可能很大，所以返回答案模 10^9 + 7.
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 *
 * 例如当 S = "abab" 时，我们有：
 *
 * dp[0] = 2，它包括 ("", "a")；
 *
 * dp[1] = 4，它包括 ("", "a", "b", "ab")；
 *
 * dp[2] = 7，它包括 ("", "a", "b", "aa", "ab", "ba", "aba")；
 *
 * dp[3] = 12，它包括 ("", "a", "b", "aa", "ab", "ba", "bb", "aab", "aba", "abb", "bab", "abab")。
 *
 * 当从 dp[2] 转移到 dp[3] 时，我们只会在 dp[2] 中的 ("b", "aa", "ab", "ba", "aba") 的末尾增加 b，而忽略掉 ("", "a")，因为它们会得到重复的子序列。我们可以发现，这里的
 * ("", "a") 刚好就是 dp[0]，也就是上一次增加 b 之前的子序列集合。
 */
public class S0940b {
    public int distinctSubseqII(String S) {
        int MOD = 1000000007;
        int len = S.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < len; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i+1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i+1] -= dp[last[x]];
            dp[i+1] %= MOD;
            last[x] = i;
        }

        dp[len]--;
        if(dp[len]<0) {
            dp[len]+=MOD;
        }
        return dp[len];
    }
}
