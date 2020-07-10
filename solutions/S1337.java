package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。

如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。

 

示例 1：

输入：mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
输出：[2,0,3]
解释：
每行中的军人数目：
行 0 -> 2 
行 1 -> 4 
行 2 -> 1 
行 3 -> 2 
行 4 -> 5 
从最弱到最强对这些行排序后得到 [2,0,3,1,4]
示例 2：

输入：mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
输出：[0,2]
解释： 
每行中的军人数目：
行 0 -> 1 
行 1 -> 4 
行 2 -> 1 
行 3 -> 1 
从最弱到最强对这些行排序后得到 [0,2,3,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

思路：
将每一行的士兵数量x1000+索引存到一个新的列表里，然后对这个列表进行排序，取前面的k位对1000取余即是需要的索引值。
 */
public class S1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int[] res = new int[k];
        int[] ls = new int[rows];
        for(int i =0;i<rows;i++){
            ls[i] = count(mat[i])*100+i;
        }
        Arrays.sort(ls);
        for(int i=0;i<k;i++){
            res[i] = ls[i] %100;
        }
        return res;
    }

    public int count(int[] nums){
        int sum=0;
        for(int n:nums){
            if(n!=1){
                break;
            }
            sum+=n;
        }
        return sum;
    }
}