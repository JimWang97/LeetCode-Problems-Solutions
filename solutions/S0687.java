package solutions;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 */
public class S0687 {
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
        int ans;
        public int longestUnivaluePath(TreeNode root) {
            ans = 0;
            helper(root);
            return ans;
        }

        private int helper(TreeNode root) {
            if(root==null) return 0;
            if(root.left==null&&root.right==null) return 1;
            int left = helper(root.left);
            int right = helper(root.right);
            if(root.left!=null&&root.right!=null&&root.val==root.left.val && root.val==root.right.val) {
                int tmp =  Math.max(left,right);
                ans = Math.max(ans, left+right);
                return tmp+1;
            } else if(root.left!=null&&root.val==root.left.val) {
                ans = Math.max(left,ans);
                return left+1;
            } else if(root.right!=null&&root.val==root.right.val) {
                ans = Math.max(right,ans);
                return right+1;
            }
            return 1;
        }
    }
}
