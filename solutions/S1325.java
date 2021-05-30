package solutions;

/**
 * 1325. 删除给定值的叶子节点
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 * <p>
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 * <p>
 * 也就是说，你需要重复此过程直到不能继续删除。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,2,null,2,4], target = 2
 * 输出：[1,null,3,null,4]
 * 解释：
 * 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 * 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
 */
public class S1325 {
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
        public TreeNode dfs(TreeNode node, int target) {
            if (node == null)
                return null;
            //对左右子树进行操作
            TreeNode left = dfs(node.left, target);
            TreeNode right = dfs(node.right, target);
            node.left = left;
            node.right = right;
            //对节点进行操作
            if (node.left == null && node.right == null && node.val == target)
                return null;
            return node;
        }

        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null)
                return null;
            return dfs(root, target);
        }
    }
}