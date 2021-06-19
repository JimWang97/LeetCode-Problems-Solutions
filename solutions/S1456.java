package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 */
public class S1456 {
    class Solution {
        public int maxVowels(String s, int k) {
            int i = 0, j =  0;
            List<Character> chars = Arrays.asList(new Character[]{'a','e','i','o','u'});
            int num = 0;
            int ans = 0;
            for(;j<k;j++) {
                if(chars.contains(s.charAt(j))) {
                    num++;
                }
            }
            ans = num;
            j--;
            while(j<s.length()) {
                j++;
                if(chars.contains(s.charAt(j))) {
                    num++;
                }
                if(chars.contains(s.charAt(i))) {
                    num--;
                }
                i++;
                ans = Math.max(num, ans);
            }
            return ans;

        }
    }
}
