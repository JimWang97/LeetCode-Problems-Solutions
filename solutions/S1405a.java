package solutions;

/**
 * 1405. 最长快乐字符串
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 *
 * 贪心算法
 * 在结果字符串最后两个字符不一样的情况下，添加三个字符中剩余次数最多的；
 * 在结果字符串最后两个字符一样的情况下，添加与最后字符不一样的另外两个字符中剩余次数较多的。
 *
 * 作者：cjjohn
 * 链接：https://leetcode-cn.com/problems/longest-happy-string/solution/javatan-xin-suan-fa-jian-ji-xie-fa-2ms-by-cjjohn/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class S1405a {
    private int[] char2num;

    private char nextChar(char exclude) {
        char next;
        if (exclude == 'a') {
            next = char2num[1] > char2num[2] ? 'b' : 'c';
        }
        else if (exclude == 'b') {
            next = char2num[0] > char2num[2] ? 'a' : 'c';
        }
        else if (exclude == 'c') {
            next = char2num[0] > char2num[1] ? 'a' : 'b';
        }
        else {
            next = char2num[0] > char2num[1] ? 'a' : 'b';
            next = char2num[next - 'a'] > char2num[2] ? next : 'c';
        }
        return next;
    }

    public String longestDiverseString(int a, int b, int c) {
        char2num = new int[] {a, b, c};

        char[] result = new char[a + b + c];
        int idx = 0;

        while (char2num[0] != 0 || char2num[1] != 0 || char2num[2] != 0) {
            char next;
            if (idx < 2 || result[idx - 1] != result[idx - 2]) {
                next = nextChar(' ');
            }
            else {
                next = nextChar(result[idx - 1]);
            }
            if (char2num[next - 'a'] <= 0) {
                break;
            }
            --char2num[next - 'a'];
            result[idx++] = next;
        }

        return new String(result, 0, idx);
    }
}
