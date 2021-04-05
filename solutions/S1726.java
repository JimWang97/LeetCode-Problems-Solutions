package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1726. 同积元组
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 */
public class S1726 {
    class Solution {
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for(int i = 0; i < nums.length; i++) {
                for(int j = i+1; j < nums.length; j++) {
                    int tmp = nums[i]*nums[j];
                    Integer val = map.getOrDefault(tmp, 0);
                    ans+=val;
                    map.put(tmp, val+1);
                }
            }
            return ans<<3;
        }
    }
}
