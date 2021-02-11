package solutions;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 */
public class S0066 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len==0) {
            return new int[]{};
        }
        for(int i = len-1; i>=0; i++) {
            if(digits[i]<9) {
                digits[i]+=1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] ans = new int[len+1];
        ans[0] = 1;
        for(int i = 1; i <=len; i++) {
            ans[i] = digits[i-1];
        }
        return ans;
    }
}
