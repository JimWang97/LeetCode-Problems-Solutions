package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出:
 * 1
 */
public class S0513 {
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
        public int findBottomLeftValue(TreeNode root) {
            if(root==null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int ans = 0;
            while(!q.isEmpty()) {
                int sz = q.size();
                for(int i = 0; i < sz; i++) {
                    TreeNode node = q.poll();
                    if(i==0) {
                        ans = node.val;
                    }
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                }
            }
            return ans;
        }
    }
}
