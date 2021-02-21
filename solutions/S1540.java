package solutions;

/**
 * 1540. K 次操作转变字符串
 * 给你两个字符串 s 和 t ，你的目标是在 k 次操作以内把字符串 s 转变成 t 。
 *
 * 在第 i 次操作时（1 <= i <= k），你可以选择进行如下操作：
 *
 * 选择字符串 s 中满足 1 <= j <= s.length 且之前未被选过的任意下标 j （下标从 1 开始），并将此位置的字符切换 i 次。
 * 不进行任何操作。
 * 切换 1 次字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 'z' 切换后会变成 'a'）。
 *
 * 请记住任意一个下标 j 最多只能被操作 1 次。
 *
 * 如果在不超过 k 次操作内可以把字符串 s 转变成 t ，那么请你返回 true ，否则请你返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "input", t = "ouput", k = 9
 * 输出：true
 * 解释：第 6 次操作时，我们将 'i' 切换 6 次得到 'o' 。第 7 次操作时，我们将 'n' 切换 7 次得到 'u' 。
 */
public class S1540 {
    public boolean canConvertString(String s, String t, int k) {
        int len = s.length();
        if(len!=t.length()){
            return false;
        }
        int[] ti = new int[27];
        for(int i = 0; i < len; i++) {
            ti[((t.charAt(i) - s.charAt(i)) + 26) % 26]++;
        }
        int time = k/26;
        int re = k % 26;
        for(int i = 1; i <=re;i++) {
            if(ti[i]>time+1) {
                return false;
            }
        }
        for(int i = re+1; i <=26; i++) {
            if(ti[i]>time) {
                return  false;
            }
        }
        return true;
    }
}
