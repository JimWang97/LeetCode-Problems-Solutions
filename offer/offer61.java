package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 */
public class offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==0) {
                count++;
            } else {
                if(i>0) {
                    while(nums[i-1]!=0){
                        if(nums[i]==nums[i-1]+1) {
                            break;
                        }
                        if(nums[i]!=nums[i-1]+1) {
                            if(count<=0) {
                                return false;
                            } else {
                                count--;
                                nums[i-1]++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
