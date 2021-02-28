package solutions;

import java.util.Arrays;

/**
 * 1657. 确定两个字符串是否接近
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 *
 * 统计两个数组里每个词出现的次数。比较分布是否一致，如果一个字符串有，而另一个没有，那么不可能通过交换相等。
 * 将分布进行排序，如果按顺序的两边都相等，说明是有办法通过交换来匹配的。
 */
public class S1657 {
    public boolean closeStrings(String word1, String word2) {
        //1、单词长度不一样直接false
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] chars = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        //统计两个字符串字符数量和位置
        int[] help1 = new int[26];
        for (Character c : chars) {
            help1[c-'a']++;
        }
        int[] help2 = new int[26];
        for (Character c : chars2) {
            help2[c-'a']++;
        }
        //排序前判断两个数组字符分布位置是否一致表示元素种类一致
        for (int i = 0; i < help1.length ; i++) {
            if (help1[i] > 0 && help2[i] == 0) {
                return false;
            }
            if (help1[i] == 0 && help2[i] > 0) {
                return false;
            }
        }
        //排序后，如果数组每个位置元素数量相等，代表可用题目解法二交换
        Arrays.sort(help1);
        Arrays.sort(help2);
        for (int i = 0; i < help1.length ; i++) {
            if (help1[i] != help2[i]) {
                return false;
            }
        }
        return true;
    }
}
