package solutions;

/**
 * 717. 1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 *
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 */
public class S0717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i;
        for(i = 0; i < bits.length-1; i++) {
            if(bits[i]==1) {
                i++;
            }
        }
        if(i==bits.length) {
            return false;
        }
        return true;
    }
}
