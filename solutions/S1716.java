package solutions;

/**
 * 1716. 计算力扣银行的钱
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 */
public class S1716 {
    public int totalMoney(int n) {
        int ans = 0;
        ans += (n/7 * 28);

        int tmp = n/7;
        int i = 1;
        while(tmp>1) {
            ans += i*7;
            i++;
            tmp--;
        }

        int re = n%7;
        int base = n/7+1;
        for(i = 0; i < re; i++) {
            ans  = ans + base + i;
        }
        return ans;
    }
}
