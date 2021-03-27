package solutions;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */
public class S0242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int len1 = s.length();
            int len2 = t.length();
            if(len1!=len2) {
                return false;
            }
            int[] nums = new int[26];
            for(int i =0;i<len1;i++) {
                nums[s.charAt(i)-'a']++;
                nums[t.charAt(i)-'a']--;
            }
            for(int i = 0;i<26;i++) {
                if(nums[i]!=0) return false;
            }
            return true;
        }
    }
}
