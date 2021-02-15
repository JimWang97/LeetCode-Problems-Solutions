package solutions;

import java.util.Arrays;
import java.util.List;

/**
 * 
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

思路：
动态规划，自下而上计算
 dp[i][j] = min(dp[i-1][j-1],dp[i-1][j])+triangle[i][j]
 */
public class S0120 {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if(triangle==null || triangle.size()==0) return 0;
//        int[] dp = new int[triangle.size()+1];
//        for(int i = triangle.size()-1;i>=0;i++){
//            List<Integer> curTr = triangle.get(i);
//            for(int j=0;j<curTr.size();j++){
//                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
//            }
//        }
//        return dp[0];
//    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j])+triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }
}