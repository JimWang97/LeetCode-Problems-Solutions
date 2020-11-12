package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

 

示例 1：


输入：root = [1,null,2,3]
输出：[1,2,3]
 */
public class S0144 {
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

    public List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
    }

    public void preorder(TreeNode node){
        if(node == null) return;
        ans.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}