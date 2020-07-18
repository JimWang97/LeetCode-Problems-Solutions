package solutions;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" 输出: true 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" 输出: false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 思路：
 * 动态规划
 * 其中dp[i][j] = s1[0~i-1]+s2[0~j-1]是否能构成s3，能就是true，不能就是false
 * 转移公式dp[i][j] = (dp[i-1][j]&&(s1[i-1]==s3[i+j-1]))||(dp[i][j-1]&&(s2[j-1]==s3[i+j-1]))
 * 时间O(n*m)
 */
public class S0097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len3 != len1 + len2)
            return false;
        boolean[][] ans = new boolean[len1+1][len2+1];
        ans[0][0]=true;
        for(int i =1;i<=len1;i++)
            ans[i][0] = ans[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        for(int i =1;i<=len2;i++)
            ans[0][i] = ans[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
        for(int i =1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                ans[i][j] = ans[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1))||ans[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return ans[len1][len2];
    }
}