package solutions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 */
public class S0368a {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Test case with empty set.
        int n = nums.length;
        if (n == 0) {
            return new ArrayList();
        }

        // Container to keep the largest divisible subset
        //   that ends with each of the nums.
        List<ArrayList> EDS = new ArrayList();
        for (int num : nums) {
            EDS.add(new ArrayList());
        }

        /* Sort the original list in ascending order. */
        Arrays.sort(nums);

        /* Calculate all the values of EDS(X_i) */
        for (int i = 0; i < n; ++i) {
            List<Integer> maxSubset = new ArrayList();

            // Find the largest divisible subset of previous elements.
            for (int k = 0; k < i; ++k) {
                if (nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size()){
                    maxSubset = EDS.get(k);
                }
            }

            // Extend the found subset with the element itself.
            EDS.get(i).addAll(maxSubset);
            EDS.get(i).add(nums[i]);
        }
        /* Find the largest of EDS values  */
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < n; ++i) {
            if (ret.size() < EDS.get(i).size()) {
                ret = EDS.get(i);
            }
        }
        return ret;
    }
}
