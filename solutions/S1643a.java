package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1643. 第 K 条最小指令
 * Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。他只能向 右 或向 下 走。你可以为 Bob 提供导航 指令 来帮助他到达目的地 destination 。
 *
 * 指令 用字符串表示，其中每个字符：
 *
 * 'H' ，意味着水平向右移动
 * 'V' ，意味着竖直向下移动
 * 能够为 Bob 导航到目的地 destination 的指令可以有多种，例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
 *
 * 然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k  的编号 从 1 开始 。
 *
 * 给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的 按字典序排列后的第 k 条最小指令 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：destination = [2,3], k = 1
 * 输出："HHHVV"
 * 解释：能前往 (2, 3) 的所有导航指令 按字典序排列后 如下所示：
 * ["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH", "VHVHH", "VVHHH"].
 */
public class S1643a {
    class Solution {
        public String kthSmallestPath(int[] destination, int k) {
            int rows = destination[0];
            int cols = destination[1];
            int h = cols;
            int v = rows;
            // 一共操作几次，已经操作了几次h
            int[][] dp = new int[h+v][h];
            dp[0][0] = 1;
            for(int i = 1; i < h+v; i++) {
                dp[i][0] = 1;
                for(int j = 1; j<=i&&j<h;j++) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }

            StringBuilder sb = new StringBuilder();

            while(h>0&&v>0) {
                int low = dp[h+v-1][h-1];
                if(k>low) {
                    sb.append("V");
                    v--;
                    k -= low;
                } else {
                    sb.append("H");
                    h--;
                }
            }
            if(h==0) {
                for(int i=0;i<v;i++){
                    sb.append("V");
                }
            } else {//如果"V"用完,则剩余位置都是"H"
                for(int i=0;i<h;i++){
                    sb.append("H");
                }
            }
            return sb.toString();
        }
    }
}
