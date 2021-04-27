package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 */
public class S0938 {
    /**
     * Definition for a binary tree node.
     **/
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
        public int rangeSumBST(TreeNode root, int low, int high) {
            int sum = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()) {
                TreeNode node = q.poll();
                if(node==null) continue;
                if(node.val < low) {
                    q.offer(node.right);
                } else if (node.val > high) {
                    q.offer(node.left);
                } else if(node.val>=low && node.val<=high) {
                    q.offer(node.left);
                    q.offer(node.right);
                    sum += node.val;
                }
            }
            return sum;
        }
    }
}
