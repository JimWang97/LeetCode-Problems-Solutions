package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 *
 *
 * 示例 1：
 *
 * 输入: [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释:
 * 最长的斐波那契式子序列为：[1,2,3,5,8] 。
 */
public class S0873a {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();//定义HashMap用来记录A中是否存在A[j]-A[i]的值map存的就是<值，索引>
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int[][] dp = new int[n][n];

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int idx = map.getOrDefault(arr[i]-arr[j], -1);
                if(idx < j && idx !=-1) {
                    dp[j][i] = dp[idx][j]+1;
                    res = Math.max(res, dp[j][i]);
                } else {
                    dp[j][i] = 2;
                }
            }
        }
        return res >=3 ? res : 0;
    }
}
