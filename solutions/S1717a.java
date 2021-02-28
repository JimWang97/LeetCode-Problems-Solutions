package solutions;

import java.util.Stack;

/**
 * 1717. 删除子字符串的最大得分
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 *
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "cdbcbbaaabab", x = 4, y = 5
 * 输出：19
 * 解释：
 * - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 * - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 * - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 * - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 * 总得分为 5 + 4 + 5 + 5 = 19 。
 *
 * 用两个栈，删了之后，那么没删的在栈内有成了连续的ab
 */
public class S1717a {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            s = new StringBuilder(s).reverse().toString();
            int t = x;
            x = y;
            y = t;
        }
        char[] chars = s.toCharArray();
        int ans = 0;
        Stack<Character> s1 = new Stack<>();
        for (char c : chars) {
            if (c == 'b') {
                if (!s1.isEmpty() && s1.peek() == 'a') {
                    s1.pop();
                    ans += x;
                } else {
                    s1.push(c);
                }
            } else {
                s1.push(c);
            }
        }

        Stack<Character> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Character c = s1.pop();
            if (c == 'b') {
                if (!s2.isEmpty() && s2.peek() == 'a') {
                    s2.pop();
                    ans += y;
                } else {
                    s2.push(c);
                }
            } else {
                s2.push(c);
            }
        }
        return ans;
    }
}
