package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 474. 一和零 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3 输出：4 解释：最多有 5 个 0
 * 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。 其他满足题意但较小的子集包括 {"0001","1"} 和
 * {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 */
public class S0474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s : strs){
            int[] count = countzeroesones(s);
            for(int zeros = m; zeros>=count[0];zeros--){
                for(int ones = n; ones>=count[1]; ones--){
                    dp[zeros][ones] = Math.max(1+dp[zeros-count[0]][ones-count[1]], dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
}