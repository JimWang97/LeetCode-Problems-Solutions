package solutions;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 */
public class S0680 {
    class Solution {
        public boolean validPalindrome(String s) {
            char[] cs = s.toCharArray();
            return helper(cs, 0, cs.length-1, false);
        }

        private boolean helper(char[] cs, int start, int end, boolean flag) {
            int i = start, j = end;
            while(i<j) {
                if(cs[i]==cs[j]) {
                    i++;
                    j--;
                } else {
                    if(!flag) {
                        return helper(cs, i+1, j, true)|helper(cs, i, j-1, true);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
