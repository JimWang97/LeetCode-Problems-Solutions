package solutions;

/**
 * 面试题 16.17. 连续数列
给定一个整数数组，找出总和最大的连续数列，并返回总和。

示例：

输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class interview_16_17 {
    public class Status {
        public Status(int i, int j, int k, int l) {
            lSum = i;
            rSum = j;
            iSum = k;
            tSum = l;
        }

        // 左边最大，右边最大，段内最大，综合
        int lSum, rSum, iSum, tSum;
    }
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length-1).iSum;
    }

    public Status helper(int[] nums, int l, int r) {
        if(l==r){
            return new Status(nums[l],nums[l],nums[l],nums[l]);
        }

        int mid = (l+r)>>1;
        Status ls = helper(nums, l, mid);
        Status rs = helper(nums, mid+1, r);
        return pushUp(ls,rs);
    }

    public Status pushUp(Status ls, Status rs){
        int tSum = ls.tSum + rs.tSum;
        int lSum = Math.max(ls.lSum, ls.tSum + rs.lSum);
        int rSum = Math.max(rs.rSum, ls.rSum + rs.tSum);
        int iSum = Math.max(Math.max(ls.iSum, rs.iSum), ls.rSum + rs.lSum);
        return new Status(lSum, rSum, iSum, tSum);
    }
}