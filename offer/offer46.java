package offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class offer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1; i < len; i++) {

            dp[i+1] = dp[i];
            if(isChar(s.charAt(i-1), s.charAt(i))) {
                dp[i+1] += dp[i-1];
            }

        }
        return dp[len];
    }

    public boolean isChar(char a, char b) {
        int an = a - '0';
        int bn = b - '0';
        if(an==0 || an>2) {
            return false;
        }
        if(a==2 && bn>5) {
            return false;
        }
        return true;
    }
}
