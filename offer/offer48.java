package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class offer48 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        for(;r<s.length();r++) {
            while(true){
                if(set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                } else {
                    break;
                }
            }
            set.add(s.charAt(r));
            ans = Math.max(r-l+1, ans);
        }
        return ans;
    }
}
