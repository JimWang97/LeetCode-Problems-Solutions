package solutions;

/**
 * 1191. K 次串联后最大子数组之和
给你一个整数数组 arr 和一个整数 k。

首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。

举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。

然后，请你返回修改后的数组中的最大的子数组之和。

注意，子数组长度可以是 0，在这种情况下它的总和也是 0。

由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。 

 

示例 1：

输入：arr = [1,2], k = 3
输出：9

 */
public class S1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int len = arr.length;
        int i;
        for(i = 0; i < len; i++){
            if(arr[i]>0) break;
        }
        if(i==len) return 0;
        long sum = 0;
        for(i = 0; i < len; i++){
            sum+=arr[i];
        }
        int e = k>=2?2:1;
        int[] dp = new int[e*len];
        long res = Integer.MIN_VALUE;
        
        for(int epoch=0; epoch<e; epoch++){
            for(int j = 0; j < len; j++) {
                if(epoch==0 && j==0) dp[0] = arr[0];
                else {
                    dp[len*epoch +j] = Math.max(dp[len*epoch + j-1]+arr[j], arr[j]);
                }
                res = Math.max(res, dp[len*epoch +j]);
            }
        }
        if(sum>0&&k>=2) res+= sum*(k-2)% 1000000007;
        return (int)res % 1000000007;
    }
}