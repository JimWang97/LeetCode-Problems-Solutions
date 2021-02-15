package solutions;

/**
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 判断first转换成second 需要执行的次数
 * 将插入删除和替换转换成转移函数
 * dp[i][j] 表示first的第i个 对应 second的第j个
 * 插入：dp[i][j] = dp[i-1][j-1]+1
 * 删除：dp[i][j] = dp[i-1][j]+1
 * 编辑：dp[i][j] = dp[i][j-1]+1
 */
public class interview_01_05 {
    public boolean oneEditAway(String first, String second) {
        if(first.equals(second)) {
            return true;
        }
        int m = first.length(), n = second.length();
        if(Math.abs(m-n)>1) {
            return false;
        }
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <=m; i++) {
            dp[i][0] = i;
        }
        for(int j = 1; j <=n; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <=m;i++) {
            for(int j=1;j<=n;j++) {
                if(first.charAt(i-1)==second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n]>1?false:true;
    }
}
