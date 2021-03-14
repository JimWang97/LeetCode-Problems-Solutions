package solutions;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 构造dp，dp[i][j]表示当前模版坐标是i，遇到字符为j的时候，下一步的状态。
 * 状态就是匹配到了第几个字符了。比如dp[0][needle.charAt[0]] = 1; 目前模版坐标0，当遇到模版第一个字符时，下一个状态就移动了下一个字符。
 * 用X记录影子状态。**所谓影子状态，就是和当前状态具有相同的前缀**。
 * 在构建当前状态 `j` 的转移方向时，只有字符 `pat[j]` 才能使状态推进（`dp[j][pat[j]] = j+1`）；而对于其他字符只能进行状态回退，应该去请教影子状态 `X` 应该回退到哪里（`dp[j][other] = dp[X][other]`，其中 `other` 是除了 `pat[j]` 之外所有字符）。
 */
public class S0028c {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.length()==0) {
                return 0;
            }
            int M = needle.length();
            int[][] dp = new int[M][256];
            dp[0][needle.charAt(0)] = 1;
            int X = 0;
            for(int i = 1; i < M; i++) {
                for(int j = 0; j < 256; j++) {
                    dp[i][j] = dp[X][j];
                }
                dp[i][needle.charAt(i)] = i+1;
                X = dp[X][needle.charAt(i)];
            }

            int len = haystack.length();
            int ans = 0;
            for(int i = 0; i < len; i++) {
                ans = dp[ans][haystack.charAt(i)];
                if(ans==M) {
                    return i-M+1;
                }
            }
            return -1;
        }
    }
}
