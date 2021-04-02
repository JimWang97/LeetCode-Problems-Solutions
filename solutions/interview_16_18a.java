package solutions;

/**
 * 面试题 16.18. 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b
 * "），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 *
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 */
public class interview_16_18a {
    class Solution {
        public boolean patternMatching(String pattern, String value) {
            String[] s = new String[2];
            return helper(s, pattern, 0, value, 0);
        }

        private boolean helper(String[] s, String pattern, int i, String value, int i1) {
            if(i==pattern.length()&&i1==value.length()) return true;
            if(i>=pattern.length()||i1>value.length()) return false;
            int num = pattern.charAt(i)-'a';
            if(s[num]==null) {
                for(int j = i1; j <= value.length(); j++) {
                    s[num] = value.substring(i1, j);
                    if(!s[num].equals(s[1-num])&&helper(s,pattern,i+1,value,j)) return true;
                }
                s[num] = null;
                return false;
            } else {
                int end=i1+s[num].length();
                if(end> value.length()||!value.substring(i1,end).equals(s[num])) return false;
                return helper(s,pattern,i+1,value,end);
            }
        }
    }
}
