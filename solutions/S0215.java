package solutions;
/**
 * 215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
 */
public class S0215 {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quickSort(0, nums.length-1, nums, target);
    }

    public int quickSort(int left, int right, int[] arr, int k){
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
            return tmp;
        } else if (i < k){
            return quickSort(i+1, right, arr, k);
        } else {
            return quickSort(left, i-1, arr, k);
        } 
    }
}