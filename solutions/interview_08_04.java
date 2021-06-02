package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class interview_08_04 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            for(int i : nums) {
                for(int j = 0; j < ans.size(); j++) {
                    List<Integer> ls = ans.get(j);
                    List<Integer> tmp = new ArrayList<>(ls);
                    tmp.add(i);
                    ans.add(tmp);
                }
            }
            return ans;
        }
    }
}
