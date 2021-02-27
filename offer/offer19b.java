package offer;

import java.util.HashMap;

/**
 * 剑指 Offer 19. 正则表达式匹配
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a
 * .a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 */
public class offer19b {
    public HashMap<String, Boolean> memo = new HashMap<>();
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        return helper(sc, pc, 0, 0);
    }
    public boolean helper(char[] s, char[] p, int si, int pi) {
        if(pi==p.length) {
            return si==s.length;
        }
        if(si==s.length) {
            if((p.length-pi)%2==1) {
                return false;
            }
            for(;pi+1<p.length;pi+=2) {
                if(p[pi+1]!='*') {
                    return false;
                }
            }
            return true;
        }

        String key = si + "," + pi;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean ans = false;

        if(s[si] == p[pi] || p[pi]=='.') {
            if(pi<p.length-1 && p[pi+1]=='*') {
                // 如果下一个是*，可以多次匹配，那么si+1,如果只匹配这一次那么pi+2
                ans = helper(s,p,si,pi+2)||helper(s,p,si+1,pi);
            } else {
                // 常规1对1匹配
                ans = helper(s,p,si+1,pi+1);
            }
        } else{
            if(pi<p.length-1 && p[pi+1]=='*') {
                // *表示0次这里，直接跳过
                ans = helper(s,p,si,pi+2);
            } else {
                ans = false;
            }
        }
        memo.put(key, ans);
        return ans;

    }
}
