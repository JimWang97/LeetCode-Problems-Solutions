package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1718. 构建字典序最大的可行序列
 * 给你一个整数 n ，请你找到满足下面条件的一个序列：
 *
 * 整数 1 在序列中只出现一次。
 * 2 到 n 之间每个整数都恰好出现两次。
 * 对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。
 * 序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。
 *
 * 请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。
 *
 * 一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0,1,9,0] 比 [0,1,5,6]
 * 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[3,1,2,3,2]
 * 解释：[2,3,2,1,3] 也是一个可行的序列，但是 [3,1,2,3,2] 是字典序最大的序列。
 */
public class S1718a {
    class Solution {

        private int n;

        private int[] ans;

        private boolean[] visited;

        // 1718. 构建字典序最大的可行序列
        public int[] constructDistancedSequence(int n) {
            this.n = n;
            ans = new int[n * 2 - 1];
            visited = new boolean[n + 1];
            backtrack(0);
            return ans;
        }

        private boolean backtrack(int idx) {
            if (idx >= ans.length) return true;
            if (ans[idx] != 0) return backtrack(idx + 1);
            for (int i = n; i > 1; i--) {
                if (!visited[i] && idx + i < ans.length && ans[idx + i] == 0) {
                    ans[idx] = ans[idx + i] = i;
                    visited[i] = true;
                    if (backtrack(idx + 1)) return true;
                    ans[idx] = ans[idx + i] = 0;
                    visited[i] = false;
                }
            }
            if (!visited[1]) {
                ans[idx] = 1;
                visited[1] = true;
                if (backtrack(idx + 1)) return true;
                ans[idx] = 0;
                visited[1] = false;
            }
            return false;
        }
    }
}
