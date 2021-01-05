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
        int strsNum = strs.length;
        int[][][] dp = new int[strsNum + 1][m + 1][n + 1];
		
        
        for (int i = 1; i <= strsNum; i++) {
            int[] cnt = count(strs[i - 1]);

            for (int j = 0; j <= m; j++) {
                for(int k = 0; k <= n; k++) {

                    if (cnt[0] > j || cnt[1] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cnt[0]][k - cnt[1]] + 1);
                    }
                }
            }
        }

        return dp[strsNum][m][n];
    }

    
    // cnt[0] = zeroNums, cnt[1] = oneNums
    public int[] count(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }
}