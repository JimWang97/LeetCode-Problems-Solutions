package solutions;

/**
 * 1754. 构造字典序最大的合并字符串
 * 给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继续操作：
 *
 * 如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
 * 例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。
 * 如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
 * 例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。
 * 返回你可以构造的字典序 最大 的合并字符串 merge 。
 *
 * 长度相同的两个字符串 a 和 b 比较字典序大小，如果在 a 和 b 出现不同的第一个位置，a 中字符在字母表中的出现顺序位于 b 中相应字符之后，就认为字符串 a 按字典序比字符串 b 更大。例如，"abcd" 按字典序比
 * "abcc" 更大，因为两个字符串出现不同的第一个位置是第四个字符，而 d 在字母表中的出现顺序位于 c 之后。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "cabaa", word2 = "bcaaa"
 * 输出："cbcabaaaaa"
 * 解释：构造字典序最大的合并字符串，可行的一种方法如下所示：
 * - 从 word1 中取第一个字符：merge = "c"，word1 = "abaa"，word2 = "bcaaa"
 * - 从 word2 中取第一个字符：merge = "cb"，word1 = "abaa"，word2 = "caaa"
 * - 从 word2 中取第一个字符：merge = "cbc"，word1 = "abaa"，word2 = "aaa"
 * - 从 word1 中取第一个字符：merge = "cbca"，word1 = "baa"，word2 = "aaa"
 * - 从 word1 中取第一个字符：merge = "cbcab"，word1 = "aa"，word2 = "aaa"
 * - 将 word1 和 word2 中剩下的 5 个 a 附加到 merge 的末尾。
 *
 * 在两个字符串中找递增的连续子串，然后选大的那个插入。
 */
public class S1754 {
    public String largestMerge(String word1, String word2) {
        char[] charArr = new char[word1.length() + word2.length()];
        //i1，j1记录word1的非递减序列（不包含j1）；i2，j2记录word2的非递减序列（不包含j2）
        //i记录返回字符串charArr的写入位置
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0, i = 0;
        boolean w1 = true;//记录写入word1的非递减序列，还是写入word2的非递减序列
        while (i1 < word1.length() || i2 < word2.length()) {
            //找出word1开头的递增序列
            if (i1 == j1) {
                while (true) {
                    if (j1 == word1.length()) {
                        break;
                    }
                    j1 ++;
                    if (j1 == word1.length() || word1.charAt(j1) < word1.charAt(j1-1)) {
                        break;
                    }
                }
            }
            //找出word2开头的非递减序列
            if (i2 == j2) {
                while (true) {
                    if (j2 == word2.length()) {
                        break;
                    }
                    j2 ++;
                    if (j2 == word2.length() || word2.charAt(j2) < word2.charAt(j2-1)) {
                        break;
                    }
                }
            }
            //比较两个序列，选大的，如果相同看序列后面的字符大小
            int temp1 = i1,temp2 = i2;
            while (true) {
                if ((temp2 >= j2 && temp1 < j1) || temp2 >= word2.length()) {
                    w1 = true;
                    break;
                }
                if ((temp1 >= j1 && temp2 < j2) || temp1 >= word1.length()) {
                    w1 = false;
                    break;
                }

                if (word1.charAt(temp1) > word2.charAt(temp2)) {
                    w1 = true;
                    break;
                }
                if (word1.charAt(temp1) < word2.charAt(temp2)) {
                    w1 = false;
                    break;
                }
                if (word1.charAt(temp1) == word2.charAt(temp2)) {
                    temp1 ++;
                    temp2 ++;
                }
            }
            //把对应的序列写入返回的字符串
            if (w1) {
                while(i1 < j1) {
                    charArr[i] = word1.charAt(i1);
                    i ++;
                    i1++;
                }
            } else {
                while(i2 < j2) {
                    charArr[i] = word2.charAt(i2);
                    i ++;
                    i2++;
                }
            }
        }

        return String.valueOf(charArr);
    }
}
