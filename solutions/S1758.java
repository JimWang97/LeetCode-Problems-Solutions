package solutions;

/**
 * 1758. 生成交替二进制字符串的最少操作数
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 *
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 *
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 */
public class S1758 {
//    public int minOperations(String s) {
//        int len = s.length();
//        int[][] dp = new int[len][2];
//        dp[0][0] = 0;
//        dp[0][1] = 1;
//        for(int i = 1; i < len; i++) {
//            if(s.charAt(i)==s.charAt(i-1)) {
//                dp[i][0] = dp[i-1][1];
//                dp[i][1] = dp[i-1][0] + 1;
//            } else {
//                dp[i-1][0] = dp[i-1][0];
//                dp[i][1] = dp[i-1][1]+1;
//            }
//        }
//        return Math.min(dp[len-1][0], dp[len-1][1]);
//    }
    public int minOperations(String s) {
        int len = s.length();
        int ans1 = 0, ans2 = 0;
        for(int i = 0; i < len; i++) {
            if(s.charAt(i)%2!=i%2) {
                ans1++;
            } else {
                ans2++;
            }
        }
        return Math.min(ans1, ans2);
    }
}
