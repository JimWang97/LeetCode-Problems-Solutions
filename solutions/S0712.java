package solutions;

/**
 * 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 *
 * dp[i][j] 表示s1的第i个与s2的第j个对应时，需要最小删除和
 * dp[i][j] = dp[i-1][j-1] 当s1[i]==s2[j]
 *          = min(dp[i-1][j] + s1[i], dp[i][j-1] + s2[j]) 当不想等的时候，选最小的删除
 */
public class S0712 {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.codePointAt(i - 1);
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + s2.codePointAt(i - 1);
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.codePointAt(i-1), dp[i][j - 1] + s2.codePointAt(j-1));
                }
            }
        }
        return dp[len1][len2];
    }
}
