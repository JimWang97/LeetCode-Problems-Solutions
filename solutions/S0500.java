package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 *
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S0500 {
    class Solution {
        public String[] findWords(String[] words) {
            String[] strings = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
            List<String> ans = new ArrayList<>();
            for(String word : words) {
                int i = 0;
                for(;i<3;i++) {
                    if(strings[i].indexOf(word.toLowerCase().charAt(0))!=-1) break;
                }
                int j;
                for(j = 0; j < word.length(); j++) {
                    if(strings[i].indexOf(word.toLowerCase().charAt(j))==-1) break;
                }
                if(j==word.length()) ans.add(word);
            }
            return ans.toArray(new String[]{});
        }
    }
}
