package solutions;

import java.util.Arrays;

/**
 * 1626. 无矛盾的最佳球队
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 *
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 *
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * 输出：34
 * 解释：你可以选中所有球员。
 */
public class S1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] tmp = new int[len][2];
        for(int i = 0; i < len; i++) {
            tmp[i][0] = scores[i];
            tmp[i][1] = ages[i];
        }
        Arrays.sort(tmp, (o1,o2)->o1[0]==o2[0]? o1[1]-o2[1] : o1[0]-o2[0]);
        int[] dp = new int[len];
        dp[0] = tmp[0][0];
        int ans = dp[0];
        for(int i = 1; i < len; i++) {
            for(int j = i-1; j>=0; j--) {
                if(tmp[j][1] <= tmp[i][1]) {
                    dp[i] = Math.max(dp[j]+tmp[i][0], dp[i]);
                }
            }
            dp[i] = Math.max(dp[i], tmp[i][0]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
