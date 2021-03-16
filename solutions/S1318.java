package solutions;

/**
 * 1318. 或运算的最小翻转次数
 * 给你三个正整数 a、b 和 c。
 *
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 *
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 */
public class S1318 {
    class Solution {
        public int minFlips(int a, int b, int c) {
            if((a|b)==c) {
                return 0;
            }
            int ans = 0;
            while(a>0 || b>0 || c>0) {
                int al = a&1;
                int bl = b&1;
                int cl = c&1;
                if((al|bl)!=cl) {
                    if(cl==1) {
                        ans++;
                    } else {
                        if((al&bl)!=0) {
                            ans+=2;
                        } else {
                            ans++;
                        }
                    }
                }
                a>>>=1;
                b>>>=1;
                c>>>=1;
            }
            return ans;
        }
    }
}
