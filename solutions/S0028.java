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
 */
public class S0028 {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int[][] dp = new int[len][256];
        int X = 0;
        if(needle.length()==0) {
            return 0;
        }
        if(haystack.length()==0) {
            return -1;
        }
        dp[0][needle.charAt(0)] = 1;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < 256; j++) {
                dp[i][j] = dp[X][j];
            }
            dp[i][needle.charAt(i)] = i+1;
            X = dp[X][needle.charAt(i)];
        }
        int j = 0;
        for(int i = 0; i < haystack.length(); i++) {
            j = dp[j][haystack.charAt(i)];
            if(j==len) {
                return i - len +1;
            }
        }
        return -1;
    }
}
