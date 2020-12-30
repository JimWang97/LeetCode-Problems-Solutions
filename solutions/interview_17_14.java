package solutions;
/**
 * 面试题 17.14. 最小K个数
设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
 */
public class interview_17_14 {
    public int[] smallestK(int[] arr, int k) {
        if(arr.length==0) return new int[0];
        return quicksort(0, arr.length-1, arr, k);
    }
    public int[] quicksort(int left, int right, int[] arr, int k){
        int i,j,tmp;
        tmp = arr[left];
        i = left;
        j = right;
        while(i!=j){
            while(arr[j]>=tmp&&i<j){
                j--;
            }
            while(arr[i]<=tmp&&i<j){
                i++;
            }
            if(i<j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = tmp;
        if(i==k) {
            int[] ans = new int[k];
            for(int o = 0; o < k; o++){
                ans[o] = arr[o];
            }
            return ans;
        } else if (i < k){
            return quicksort(i+1, right, arr, k);
        } else {
            return quicksort(left, i-1, arr, k);
        } 
    }
}