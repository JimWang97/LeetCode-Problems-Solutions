package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1647. 字符频次唯一的最小删除次数
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 *
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 *
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 */
public class S1647 {
    public int minDeletions(String s) {
        int[] d = new int[26];
        for(int i = 0; i < s.length(); i++) {
            d[s.charAt(i)-'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if(!set.contains(d[i])) {
                set.add(d[i]);
            } else {
                int tmp = d[i];
                while(tmp>0) {
                    tmp--;
                    ans++;
                    if(!set.contains(tmp)) {
                        set.add(tmp);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
