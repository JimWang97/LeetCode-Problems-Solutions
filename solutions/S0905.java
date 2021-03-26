package solutions;

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class S0905 {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int len = A.length;
            int i = 0, j = len -1;
            while(i<j) {
                while(i<j&&A[i]%2==0) i++;
                while(i<j&&A[j]%2==1) j--;
                if(i<j) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
            return A;
        }
    }
}
