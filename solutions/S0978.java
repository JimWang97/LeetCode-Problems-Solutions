package solutions;

/**
 * 978. 最长湍流子数组
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

返回 A 的最大湍流子数组的长度。

 

示例 1：

输入：[9,4,2,10,7,8,8,1,9]
输出：5
解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 */
public class S0978 {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int anchor = 0;
        for(int i = 1; i < arr.length; i++){
            int c = Integer.compare(arr[i-1], arr[i]);
            if(i == arr.length-1 || c*Integer.compare(arr[i],arr[i+1])!=-1){
                if(c!=0)ans= Math.max(ans, i-anchor+1);
                anchor = i;
            }

        }
        return ans;
    }
}