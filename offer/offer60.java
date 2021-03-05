package offer;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 */
public class offer60 {
    public double[] dicesProbability(int n) {
        double[][] dp = new double[n][6*n];
        for(int i = 0; i < 6; i++) {
            dp[0][i] = 1.0/6;
        }
        for(int i = 1; i < n; i++) {
            for(int j = i; j < (i+1)*6; j++) {
                for(int k = 1; k <=6 && k<=j; k++) {
                    dp[i][j] += dp[i-1][j-k]/6.0;
                }
            }
        }
        double[] ans = new double[n*6-n+1];
        System.arraycopy(dp[n-1],n-1,ans,0,n*6-n+1);
        return ans;
    }
}
