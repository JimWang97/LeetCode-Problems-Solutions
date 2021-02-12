package solutions;

/**
 * 486. 预测赢家
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，……
 * 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 */
public class S0486 {
//    public boolean PredictTheWinner(int[] nums) {
//        int len = nums.length;
//        if(len==1) {
//            return true;
//        }
//        if(len%2==0) {
//            return true;
//        }
//        int tmp1 = 0, tmp2 = 0;
//        int tmp3 = 0, tmp4 = 0;
//        for(int i = 0; i < len; i++) {
//            if(i>=1) {
//                if(i%2==0) {
//                    tmp1 += nums[i];
//                } else {
//                    tmp2 += nums[i];
//                }
//            }
//            if(i<len-1) {
//                if(i%2==0) {
//                    tmp3 += nums[i];
//                } else {
//                    tmp4 += nums[i];
//                }
//            }
//        }
//        if(Math.abs(tmp1-tmp2)<nums[0] || Math.abs(tmp3-tmp4)<nums[len-1]) {
//            return true;
//        }
//        return false;
//    }
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        if (len % 2 == 0) {
            return true;
        }
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = len - 2; i >=0; i--) {
            for(int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][len-1]>=0;
    }
}
