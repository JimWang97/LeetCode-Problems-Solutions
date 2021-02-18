package solutions;

/**
 * 1518. 换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 */
public class S1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while(numBottles>=numExchange) {
            int nextState;
            int exchange = numBottles/numExchange;
            ans+=exchange;
            nextState = exchange + numBottles%numExchange;
            numBottles = nextState;
        }
        return ans;
    }

    public static void main(String[] args) {
        numWaterBottles(9, 3);
    }
}
