package solutions;

import java.util.*;
import java.util.Map.Entry;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入:
 * <p>
 * 5
 * /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 */
public class S0508 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int ans = 0;
        Map<Integer, Integer> map;
        public int[] findFrequentTreeSum(TreeNode root) {
            map = new HashMap<>();
            helper(root);
            List<Integer> ls = new ArrayList<>();
            Set<Integer> keys = map.keySet();
            for(Integer key : keys) {
                if(map.get(key)==ans) {
                    ls.add(key);
                }
            }
            int[] ints = ls.stream().mapToInt(i -> i).toArray();
            return ints;
        }

        private int helper(TreeNode root) {
            if(root==null) return 0;
            int left = helper(root.left);
            int right = helper(root.right);
            int sum = left + right + root.val;
            Integer integer = map.getOrDefault(sum,0);
            map.put(sum, integer+1);
            if(ans<integer+1) ans = integer+1;
            return sum;
        }
    }
}
