package solutions;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 */
public class S0647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for(int j = 1; j < len; j++) {
            for(int i = j-1; i>=0; i--) {
                dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                if(isHuiWen(s.substring(i,j+1))) {
                    dp[i][j]+=1;
                }
            }
        }
        return dp[0][len-1];
    }

    public boolean isHuiWen(String a) {
        if(a.length()==1) {
            return true;
        }
        int i = 0, j = a.length()-1;
        while(i<=j) {
            if(a.charAt(i)==a.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
