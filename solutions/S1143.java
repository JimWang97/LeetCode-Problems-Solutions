package solutions;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 */
public class S1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for(int i = 0 ; i < len1; i++) {
            for(int j = 0; j < len2; j++) {
                if(i==0&&j==0) {
                    dp[i][j] = text1.charAt(i)==text2.charAt(j)?1:0;
                } else if(i==0) {
                    dp[i][j] = text1.charAt(i)==text2.charAt(j)?1:0;
                    dp[i][j] = Math.max(dp[i][j-1], dp[i][j]);
                } else if(j==0) {
                    dp[i][j] = text1.charAt(i)==text2.charAt(j)?1:0;
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    if(text1.charAt(i)==text2.charAt(j)) {
                        dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
                    }
                }
            }
        }
        return dp[len1-1][len2-1];
    }
}
