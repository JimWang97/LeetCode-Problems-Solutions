package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 859. 亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 *
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。
 */
public class S0859 {
    class Solution {
        public boolean buddyStrings(String s, String goal) {
            if(s.length()!=goal.length()) return false;
            List<Integer> ls = new ArrayList<>();
            int[] ch = new int[26];
            boolean flag = false;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i)!=goal.charAt(i)) {
                    ls.add(i);
                }
                ch[s.charAt(i)-'a']++;
                if(ch[s.charAt(i)-'a']>=2) flag = true;
            }
            if(ls.size()==2) {
                if(s.charAt(ls.get(0))==goal.charAt(ls.get(1)) && s.charAt(ls.get(1))==goal.charAt(ls.get(0))) {
                    return true;
                }
            } else if (ls.size()==0&&flag) return true;
            return false;
        }
    }
}
