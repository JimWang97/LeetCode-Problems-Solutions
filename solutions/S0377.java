package solutions;

import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 */
public class S0377 {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int num = target / nums[0];
        int[][] dp = new int [num+1][target+1];
        Arrays.fill(dp[0], 0);
        for(int n : nums) {
            if(n<=target) {
                dp[1][n] = 1;
            }

        }
        for(int i = 2; i <= num; i++) {
            for(int j = i; j <= target; j++) {
                for(int k = 0; k < len; k++) {
                    if(j>=nums[k]){
                        dp[i][j] = dp[i][j] + dp[i-1][j-nums[k]];
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0; i <=num; i++) {
            sum+=dp[i][target];
        }
        return sum;
    }
}
