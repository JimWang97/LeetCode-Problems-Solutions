package solutions;

/**
 * 915. 分割数组
 * 给定一个数组 A，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 */
public class S0915 {
    class Solution {
        public int partitionDisjoint(int[] A) {
            int n = A.length;
            int max = A[0];
            int leftMax = A[0];
            int pos = 0;
            for(int i = 0; i < n; i++){
                max = Math.max(max, A[i]);
                if(A[i] >= leftMax)
                    continue;
                leftMax = max;
                pos = i;
            }
            return pos+1;
        }
    }
}
