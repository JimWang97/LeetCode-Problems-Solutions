package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class S0113 {
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
        List<List<Integer>> ans;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            ans = new ArrayList<>();
            if(root==null) return ans;
            helper(root, targetSum, new ArrayList<Integer>());
            return ans;
        }

        private void helper(TreeNode root, int targetSum, ArrayList<Integer> integers) {
            if(root.left==null && root.right==null) {
                if(targetSum==root.val) {
                    integers.add(root.val);
                    ans.add(new ArrayList<>(integers));
                    integers.remove(integers.size()-1);
                }
                return;
            }
            integers.add(root.val);
            if(root.left!=null)
                helper(root.left, targetSum-root.val, integers);
            if(root.right!=null)
                helper(root.right, targetSum-root.val, integers);
            integers.remove(integers.size()-1);
        }
    }
}
