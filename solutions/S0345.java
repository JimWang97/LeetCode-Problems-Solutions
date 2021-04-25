package solutions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 */
public class S0345 {
    class Solution {
        public String reverseVowels(String s) {
            int len = s.length();
            int i = 0, j = len-1;
            char[] chars = s.toCharArray();
            List<Character> ls = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
            while(i<j) {
                while(i<j&&!ls.contains(chars[i])) {
                    i++;
                }
                while(i<j&&!ls.contains(chars[j])) {
                    j--;
                }
                if(i<j) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                    i++;
                    j--;
                }
            }
            return new String(chars);
        }
    }
}
