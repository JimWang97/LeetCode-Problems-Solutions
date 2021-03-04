package offer;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 */
public class offer55_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }

    public int helper(TreeNode node) {
        if(node==null) {
            return 0;
        }
        int left = helper(node.left);
        if(left<0) {
            return -1;
        }
        int right = helper(node.right);
        if(right<0) {
            return -1;
        }
        return  Math.abs(left-right) >= 2 ? -1 : Math.max(left,right)+1;
    }
}
