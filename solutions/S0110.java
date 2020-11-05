package solutions;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

时间复杂度O(n)
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class S0110 {

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

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left = travel(root.left);
        int right = travel(root.right);
        if(left==-1 || right == -1) return false;
        return (left-right<-1 || left-right>1) ? false : true;
    }

    public int travel(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = travel(node.left);
        int right = travel(node.right);

        if(left==-1 || right == -1 || left-right<-1 || left-right>1){
            return -1;
        }
        return Integer.max(left, right)+1;
    }
}