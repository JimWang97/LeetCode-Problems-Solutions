package solutions;

/**
 * 395. 至少有K个重复字符的最长子串
找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

示例 1:

输入:
s = "aaabb", k = 3

输出:
3

最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 */
public class S0395 {
    public int longestSubstring(String s, int k) {
        int res = 0;
        boolean[] flag = new boolean[26];
        int[] num = new int[26];
        for(int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(num[i]<k) {
                flag[i] = true;
            }
        }
        int start = 0;
        boolean f = true;
        for(int i = 0; i < s.length(); i++) {
            if(flag[s.charAt(i) - 'a']){
                f = false;
                if(start<i) {
                    res = Integer.max(res, longestSubstring(s.substring(start, i), k));
                }
                start = i + 1;
            }
        }
        if (f) {
            return s.length();
        } else {
            if ( start < s.length()){
                res = Integer.max(res, longestSubstring(s.substring(start, s.length()), k));
            }
        }
        return res;
    }
}