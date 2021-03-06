package offer;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 先从左往右累乘
 * 然后从有往左累乘
 */
public class offer66a {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] B = new int[len];
        for(int i = 0, product = 1; i<len;product*=a[i],i++) {
            B[i] = product;
        }
        for(int i = len-1, product=1;i>=0;product*=a[i],i--) {
            B[i] *= product;
        }
        return B;
    }
}
