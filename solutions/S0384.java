package solutions;

import java.util.Random;

/**
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 */
public class S0384 {
    class Solution {
        int[] nums;
        int[] store;

        public Solution(int[] nums) {
            this.nums = nums;
            store = new int[nums.length];
            System.arraycopy(nums,0,store,0,nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            System.arraycopy(store,0,nums,0,store.length);
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Random rand = new Random();
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                int randIndex = rand.nextInt(n-i)+i;
                swap(nums, randIndex, i);
            }
            return nums;
        }

        private void swap(int[] nums, int randIndex, int i) {
            int tmp = nums[randIndex];
            nums[randIndex] = nums[i];
            nums[i] = tmp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
