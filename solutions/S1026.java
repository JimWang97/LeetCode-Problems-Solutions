package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1026. Maximum Difference Between Node and Ancestor Given the root of a binary
 * tree, find the maximum value V for which there exist different nodes A and B
 * where V = |A.val - B.val| and A is an ancestor of B.
 * 
 * A node A is an ancestor of B if either: any child of A is equal to B, or any
 * child of A is an ancestor of B.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13] Output: 7 Explanation: We
 * have various ancestor-node differences, some of which are given below : |8 -
 * 3| = 5 |3 - 7| = 4 |8 - 1| = 7 |10 - 13| = 3 Among all possible differences,
 * the maximum value of 7 is obtained by |8 - 1| = 7.
 * 
 */
public class S1026 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        //如果当前节点没有子节点，则直接返回
        helper(root, root.val, root.val);
        return res;
    }

    private void helper(TreeNode node, int max, int min) {
        if (node == null) return;
        max = Math.max(node.val, max);
        min = Math.min(node.val, min);
        //到达叶子节点，求最大差值
        if (node.left == null && node.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }
        helper(node.left, max, min);
        helper(node.right, max, min);
    }
}