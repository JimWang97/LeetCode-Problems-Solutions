package solutions;

/**
 * 516. 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 *
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 */
public class S0516a {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 0) {
            return 0;
        }
        int[][] dp = new int[len][len];
        for(int i = len-1; i>=0;i--){
            dp[i][i] = 1;
            for(int j = i+1;j<len;j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
