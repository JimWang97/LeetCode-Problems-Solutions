package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 98. 验证二叉搜索树 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。 示例 1:
 * 
 * 输入: 2 / \ 1 3 输出: true
 */
public class S0098 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    // 中序遍历
    private boolean inorder(TreeNode node) {
        if(node == null) return true;
        boolean l = inorder(node.left);
        if(node.val <= pre) return false;
        pre = node.val;
        boolean r = inorder(node.right);
        return l && r;
    }
}