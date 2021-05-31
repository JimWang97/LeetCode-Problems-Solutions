package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 04.12. 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 */
public class interview_04_12a {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return helper(root, map, sum, 0);
        }

        private int helper(TreeNode node, Map<Integer, Integer> prefixSum, int sum, int curSum) {
            if (node == null) {
                return 0;
            }
            curSum += node.val;
            int count = prefixSum.getOrDefault(curSum - sum, 0);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
            count += helper(node.left, prefixSum, sum, curSum);
            count += helper(node.right, prefixSum, sum, curSum);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) - 1);
            return count;
        }
    }
}
