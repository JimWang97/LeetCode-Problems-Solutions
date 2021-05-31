package solutions;

/**
 * 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 */
public class interview_04_05 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root==null) return true;
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(TreeNode root, long minValue, long maxValue) {
            if(root==null) return true;
            if(root.val<=minValue||root.val>=maxValue) return false;
            return dfs(root.left, minValue, root.val)&&dfs(root.right, root.val, maxValue);
        }
    }
}
