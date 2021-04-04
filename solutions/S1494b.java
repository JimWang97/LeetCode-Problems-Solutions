package solutions;

import java.util.*;

/**
 * 1494. 并行课程 II
 * 给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 dependencies 中， dependencies[i] = [xi, yi]  表示一个先修课的关系，也就是课程 xi 必须在课程 yi
 * 之前上。同时你还有一个整数 k 。
 *
 * 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
 *
 * 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
 * 输出：3
 * 解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
 */
public class S1494b {
    class Solution {
        public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
            int[] pre = new int[n]; // 每门课的先修课程
            for(int[] dependency : dependencies) {
                dependency[0]--;
                dependency[1]--;
                pre[dependency[1]] |= (1<<dependency[0]); //状态压缩，二进制的每一位表示一门课。n门课，就n位
            }

            int all = 1<<n; // 共all门课
            int[] dp = new int[all];
            for (int i = 0; i < all; i++) dp[i] = n;
            dp[0] = 0;
            for(int state = 0; state < all; state++) {
                int next = 0; // 当前状态下，之后可以选修的课
                for(int i = 0; i < n; i++) {
                    if((state&pre[i])==pre[i]) { // 当前state达到了第i门课的先修课程条件
                        next |= 1<<i; // 把这门课可选的课加入next
                    }
                }
                next &= ~state; //去重，只留下之后可以选修的，把重复的state去掉
                for(int sub = next; sub>0; sub = (sub-1)&next) {//举例了next所有可能的子集。比如111的子集110，这个做法每次删除最后一个1
                    if(Integer.bitCount(sub)<=k) { //一次最多k门课
                        dp[state|sub] = Math.min(dp[state|sub], dp[state]+1);
                    }
                }
            }
            return dp[all-1];
        }
    }
}
