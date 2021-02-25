package solutions;

/**
 * 1674. 使数组互补的最少操作次数
 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
 *
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] +
 * nums[n - 1 - i] = 5 。
 *
 * 返回使数组 互补 的 最少 操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,4,3], limit = 4
 * 输出：1
 * 解释：经过 1 次操作，你可以将数组 nums 变成 [1,2,2,3]（加粗元素是变更的数字）：
 * nums[0] + nums[3] = 1 + 3 = 4.
 * nums[1] + nums[2] = 2 + 2 = 4.
 * nums[2] + nums[1] = 2 + 2 = 4.
 * nums[3] + nums[0] = 3 + 1 = 4.
 * 对于每个 i ，nums[i] + nums[n-1-i] = 4 ，所以 nums 是互补的。
 */
public class S1674a {
    public int minMoves(int[] nums, int limit) {
        int[] target = new int[limit*2+2];

        int n =nums.length;
        for(int i=0;i<n/2; ++i){
            int a =Math.min(nums[i],nums[n-i-1]);
            int b =Math.max(nums[i],nums[n-i-1]);
            // [2，min]之间的，都是需要操作2次的
            // [min+1,min+max]之间的操作1次就行了
            // min+max 的不需要操作
            // min+max1, max+limit 操作1次
            // max+limit+1, limit+limit 的操作2次
            // target数组就是说最终确定的和的数组。那么只要找最小的即可
            //先给整个范围+2
            target[2] +=2;

            //其中 [1+a,b+limit] -1
            target[1+a] += -1;
            target[b+limit+1] -= -1;

            //区间 [a+b,a+b] -1
            target[a+b] += -1;
            target[a+b+1] -= -1;
        }

        //取出差分数组中的最小值
        int res =Integer.MAX_VALUE;
        // 差分求和。
        int sum=0;
        for(int i=2;i<2*limit+1; ++i){
            sum += target[i];
            res = Math.min(res,sum);
        }
        return res;
    }
}
