package solutions;

import java.util.Arrays;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：DP。后一天的情况根据前一天的max来决定。
设：
f[i][0]：有股票
f[i][1]：没有股票，是冷冻期
f[i][2]：没有股票，不是冷冻期
转移方程：
f[i][0]=max(f[i-1][0], f[i-1][2]-prices[i]);
f[i][1]=f[i-1][0]+prices[i];
f[i][2]=max(f[i-1][1],f[i-1][2])

初始状态:
f[0][0]=-prices[0];
f[0][1]=0
f[0][2]=0

注意到f[i]至于f[i-1]有关，无需要数组存储
 */
public class S0309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0) {
            return 0;
        }
        int[][] dp = new int[len][3];
        // 0有股票 1没股票冷冻期 2没股票非冷冻期
        dp[0][0] = -prices[0];
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(Math.max(dp[len-1][0], dp[len-1][1]),dp[len-1][2]);
    }
}