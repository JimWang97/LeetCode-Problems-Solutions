package solutions;

/**
 * 1186. 删除一次得到子数组最大和
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 *
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 *
 * 注意，删除一个元素后，子数组 不能为空。
 *
 * 请看示例：
 *
 * 示例 1：
 *
 * 输入：arr = [1,-2,0,3]
 * 输出：4
 * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 */
public class S1186 {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        // 最后一维 0表示还未过了，1表示已经删除过了
        int[][] dp = new int[len][2];
        dp[0][0] = arr[0];
        int ans = arr[0];
        for(int i = 1; i<len;i++) {
            dp[i][0] = Math.max(dp[i-1][0], 0) + arr[i];
            dp[i][1] = Math.max(dp[i-1][1]+arr[i], dp[i-1][0]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}
