package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 *
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 */
public class S1780 {
    class Solution {
        Set<Integer> set = new HashSet<>();
        public boolean checkPowersOfThree(int n) {
            if(n==0) return true;
            int i;
            for(i = 0; i < n/3;i++) {
                if(Math.pow(3,i+1)>n) break;
            }
            if(set.contains(i)) return false;
            set.add(i);
            return checkPowersOfThree((int) (n-Math.pow(3,i)));
        }
    }
}
