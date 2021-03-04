package offer;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 */
public class offer56_2a {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int[] bitSumArray = new int[32];    // 用于记录 数组中所有数字 的 每一位的和
        for (int num : nums) {
            /*
                由高到低，遍历当前数字的每一位，
                若 当前位为1，则使bitSumArray数组的相应的单元的值+1
            */
            int curBit = 1;
            for (int i = 31; i >= 0; i--) {
                if ((curBit & num) != 0) {
                    bitSumArray[i]++;
                }
                curBit <<= 1;
            }
        }

        /*
            计算结果：
                遍历bitSumArray数组的每一位，取每一位和3取余的结果（肯定为0或1）
                并将其 加入到 结果result的适当位上
        */
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += bitSumArray[i] % 3;
        }

        return result;
    }

}
