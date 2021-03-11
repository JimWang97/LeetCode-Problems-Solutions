package solutions;

import java.util.HashMap;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 */
public class S0010b {
    class Solution {
        public boolean isMatch(String s, String p) {
            HashMap<String, Boolean> memo = new HashMap<>();
            return helper(s, p, 0, 0, memo);
        }

        public boolean helper(String s, String p, int i, int j, HashMap<String, Boolean> memo) {
            if(j==p.length()) {
                return i==s.length();
            }
            if(i==s.length()) {
                if((p.length()-j)%2==1){
                    return false;
                }
                for(;j+1<p.length();j+=2) {
                    if(p.charAt(j+1)!='*'){
                        return false;
                    }
                }
                return true;
            }
            String key = i+","+j;
            if(memo.containsKey(key)) {
                return memo.get(key);
            }

            boolean ans = false;
            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') {
                if(j<p.length()-1&&p.charAt(j+1)=='*') {
                    // 注意这里的两个
                    ans = helper(s,p,i+1,j,memo) || helper(s,p,i,j+2,memo);
                } else {
                    ans = helper(s,p,i+1,j+1,memo);
                }
            } else {
                if(j<p.length()-1&&p.charAt(j+1)=='*') {
                    ans = helper(s,p,i,j+2,memo);
                } else {
                    return false;
                }
            }
            memo.put(key, ans);
            return ans;
        }
    }
}
