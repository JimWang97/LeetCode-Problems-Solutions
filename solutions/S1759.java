package solutions;

/**
 * 1759. 统计同构子字符串的数目
 * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 *
 * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同构子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 */
public class S1759 {
    public int countHomogenous(String s) {
        long ans = 0;
        long mov = 1;
        ans+=mov;
        for(int i = 1;i<s.length();i++) {
            if(s.charAt(i)==s.charAt(i-1)) {
                mov = (mov+1)%1000000007;
                ans=(ans+mov)%1000000007;
            } else {
                mov = 1;
                ans=(ans+mov)%1000000007;
            }
        }
        return (int)ans%1000000007;
    }
}
