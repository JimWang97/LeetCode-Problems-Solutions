package solutions;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] *
 * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i
 * 后，气球 left 和气球 right 就变成了相邻的气球。
 * 
 * 求所能获得硬币的最大数量。
 * 
 * 说明:
 * 
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤
 * 100 示例:
 * 
 * 输入: [3,1,5,8] 输出: 167 解释: nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] -->
 * []   coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 思路： 动态规划。dp[i][j]表示(i,j)能够得到的最多硬币数，边界条件是i>=j-1。dp[i][j]=0 
 * 转移方程： dp[i][j]=max val[i]*val[k]*val[j] + dp[i][k] + dp[k][j] (i<j-1)
 * 
 * 为什么大部分题解是倒序递推？ 这个现象常常出现在动态规划题里，很多都会用到倒推，特别是用dp[i][j] 表示的某个区间的时候。。。答案就是：动态规划在求解子问题一定要在父问题之前，假设这里父问题是求解 dp[2][8]，对应的子问题有“求解 dp[5][8]”，如果这里外层索引循环用顺序，会发现，求解 dp[2][8] 会在求解 dp[5][8] 之前进行。。。显然就不符合动态规划的规则了。当然也可以顺序，比如外层循环不是数组的一级索引，而是区间长度。。。这样子是可以顺序的。
 * 
 * 时间复杂度 O(n^3)
 */
public class S0312 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] ans = new int[len + 2][len + 2];
        int[] val = new int[len + 2];
        System.arraycopy(nums, 0, val, 1, len);
        val[0] = val[len + 1] = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 2; j <= len + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += ans[i][k] + ans[k][j];
                    ans[i][j] = Math.max(ans[i][j], sum);
                }
            }
        }
        return ans[0][len + 1];
    }
}