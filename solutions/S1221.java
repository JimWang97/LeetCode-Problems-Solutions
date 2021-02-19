package solutions;

/**
 * 1221. 分割平衡字符串
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 */
public class S1221 {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int tmp = 0;
        int i = 0;
        while(i<s.length()) {
            if(s.charAt(i)=='R') {
                tmp++;
            } else {
                tmp--;
            }
            if(tmp==0) {
                ans++;
            }
            i++;
        }
        return ans;
    }
}
