package solutions;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 */
public class S0123 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        // 第一个2表示 手上无股票0 和有股票1， 第二个2表示没买过，第一次买和第二次买
        int[][][] dp = new int[len][2][3];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -prices[0];
        for(int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0]-prices[i]);
            dp[i][0][1] = Math.max(dp[i-1][1][1]+prices[i], dp[i-1][0][1]);
            dp[i][1][2] = Math.max(dp[i-1][1][2], dp[i-1][0][1]-prices[i]);
            dp[i][0][2] = Math.max(dp[i-1][0][2], dp[i-1][1][2]+prices[i]);
        }
        return Math.max(Math.max(dp[len-1][0][0],dp[len-1][0][1]),dp[len-1][0][2]);
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1,2,3,4,5});
    }
}
