package solutions;

import java.util.Arrays;

/**
 * 935. 骑士拨号器
 * 国际象棋中的骑士可以按下图所示进行移动：
 *
 *  .
 *
 *
 * 这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。
 *
 * 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。
 *
 * 你能用这种方式拨出多少个不同的号码？
 *
 * 因为答案可能很大，所以输出答案模 10^9 + 7。
 *
 *
 *
 * 示例 1：
 *
 * 输入：1
 * 输出：10
 */
public class S0935 {
    public int knightDialer(int n) {
        if(n==0) {
            return 0;
        } else if(n==1) {
            return 10;
        }
        long[][] dp = new long[n][10];
        Arrays.fill(dp[0], 1);
        int i = 0;
        for(i = 1; i < n - 1; i++) {
            dp[i][0] = (dp[i-1][4] + dp[i-1][6]) % 1000000007;
            dp[i][1] = (dp[i-1][6] + dp[i-1][8]) % 1000000007;
            dp[i][2] = (dp[i-1][7] + dp[i-1][9]) % 1000000007;
            dp[i][3] = (dp[i-1][4] + dp[i-1][8]) % 1000000007;
            dp[i][4] = (dp[i-1][3] + dp[i-1][9] + dp[i-1][0]) % 1000000007;
            dp[i][5] = 0;
            dp[i][6] = (dp[i-1][1] + dp[i-1][7] + dp[i-1][0]) % 1000000007;
            dp[i][7] = (dp[i-1][2] + dp[i-1][6]) % 1000000007;
            dp[i][8] = (dp[i-1][1] + dp[i-1][3]) % 1000000007;
            dp[i][9] = (dp[i-1][2] + dp[i-1][4]) % 1000000007;
        }
        long ans = 2 * (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][7] + dp[i-1][8] +dp[i-1][9]) + 3 * (dp[i-1][4] + dp[i-1][6]);
        return (int)(ans % 1000000007);
    }

//    public static void main(String[] args) {
//        knightDialer(2);
//    }
}
