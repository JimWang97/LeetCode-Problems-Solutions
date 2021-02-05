package solutions;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 */
public class S0009 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        int i = 0, j = len-1;
        while (i <= j) {
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
