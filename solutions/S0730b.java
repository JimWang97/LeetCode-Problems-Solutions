package solutions;

/**
 * 730. 统计不同回文子序列
 * 给定一个字符串 S，找出 S 中不同的非空回文子序列个数，并返回该数字与 10^9 + 7 的模。
 *
 * 通过从 S 中删除 0 个或多个字符来获得子序列。
 *
 * 如果一个字符序列与它反转后的字符序列一致，那么它是回文字符序列。
 *
 * 如果对于某个  i，A_i != B_i，那么 A_1, A_2, ... 和 B_1, B_2, ... 这两个字符序列是不同的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * S = 'bccb'
 * 输出：6
 * 解释：
 * 6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
 * 注意：'bcb' 虽然出现两次但仅计数一次。
 *
 * dp[k][i][j] 表示回文的最外层是第k个字符，从i到j的回文数。
 * 当i==j并且S.ca(i)==k的时候，dp[k][i][j]==1
 * 当S.ca(i)==k,S.ca(j)==k的时候，dp[k][i][j] = dp[1-4][i+1][j-1]
 */
public class S0730b {
    public int countPalindromicSubsequences(String S) {
         int len = S.length();
        int mod = 1000000007;
         int[][][] dp = new int[4][len][len];
         for(int i = len-1;i>=0;i--) {
             for(int j = i; j<len;j++) {
                 for(int k =0;k<4;k++) {
                     char c= (char) ('a' + k);
                     if(j==i) {
                         if(S.charAt(i)==c) {
                             dp[k][i][j] = 1;
                         } else {
                             dp[k][i][j] = 0;
                         }
                     } else {
                         if(S.charAt(i)!=c) {
                             dp[k][i][j] = dp[k][i+1][j];
                         } else if(S.charAt(j)!=c) {
                             dp[k][i][j] = dp[k][i][j-1];
                         } else {
                             if(j==i+1) {
                                 dp[k][i][j] = 2;
                             } else {
                                 dp[k][i][j] = 2;
                                 for(int m = 0; m < 4; m++) {
                                     dp[k][i][j] += dp[m][i+1][j-1];
                                     dp[k][i][j]%=mod;
                                 }
                             }
                         }
                     }
                 }
             }
         }
         int ans = 0;
         for(int k = 0; k < 4; k++) {
             ans+=dp[k][0][len-1];
             ans%=mod;
         }
         return ans;
    }
}
