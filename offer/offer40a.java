package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
public class offer40a {
    public int[] getLeastNumbers(int[] arr, int k) {
        helper(arr,k, 0, arr.length-1);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public void helper(int[]arr, int k, int lo, int hi) {
        if(lo>=hi) {
            return;
        }
        int l = lo, r = hi;
        int par = arr[l];
        while(l<r) {
            while(l<r && arr[r]>=par) {
                r--;
            }
            arr[l] = arr[r];
            while(l<r && arr[l]<=par) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = par;
        if(l==k) {
            return;
        } else if(l<k) {
            helper(arr, k, l+1, hi);
        } else {
            helper(arr, k, lo, l-1);
        }
    }
}
