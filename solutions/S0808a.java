package solutions;

import java.util.Arrays;

/**
 * 808. 分汤
 * 有 A 和 B 两种类型的汤。一开始每种类型的汤有 N 毫升。有四种分配操作：
 *
 * 提供 100ml 的汤A 和 0ml 的汤B。
 * 提供 75ml 的汤A 和 25ml 的汤B。
 * 提供 50ml 的汤A 和 50ml 的汤B。
 * 提供 25ml 的汤A 和 75ml 的汤B。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为0.25的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 *
 * 注意不存在先分配100 ml汤B的操作。
 *
 * 需要返回的值： 汤A先分配完的概率 + 汤A和汤B同时分配完的概率 / 2。
 *
 * 示例:
 * 输入: N = 50
 * 输出: 0.625
 * 解释:
 * 如果我们选择前两个操作，A将首先变为空。对于第三个操作，A和B会同时变为空。对于第四个操作，B将首先变为空。
 * 所以A变为空的总概率加上A和B同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 *
 * 每一个选到的概率都是0.25。 将100/25 变成4。
 */
public class S0808a {
    public double soupServings(int N) {
        if(N>=4800)return 1;
        N=N/25+((N%25==0)?0:1);
        double dp[][]=new double[N+1][N+1];
        Arrays.fill(dp[0],1);
        dp[0][0]=0.5;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                dp[i][j]=0.25*(dp[Math.max(0,i-4)][j]+dp[Math.max(0,i-3)][Math.max(0,j-1)]+dp[Math.max(0,i-2)][Math.max(0,j-2)]+dp[Math.max(0,i-1)][Math.max(0,j-3)]);
            }
        }
        return dp[N][N];
    }
}
