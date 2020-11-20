package solutions;

/**
 * 669. Trim a Binary Search Tree
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

 

Example 1:


Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
 */
public class S0669 {
    // public class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode() {}
    //     TreeNode(int val) { this.val = val; }
    //     TreeNode(int val, TreeNode left, TreeNode right) {
    //         this.val = val;
    //         this.left = left;
    //         this.right = right;
    //     }
    // }

    // public TreeNode trimBST(TreeNode root, int low, int high) {
    //     if(root==null) return null;
    //     return helper(root, low, high);
    // }

    // public TreeNode helper(TreeNode node, int low, int high){
    //     if(node.left.val<low){
    //         node.left = node.left.right;
    //     }
    //     else if(node.left.val>high) node.left=node.left.left;
    //     if(node.right.val>high){
    //         node.right = node.right.left;
    //     }
    //     else if(node.right.val<low) node.right = node.right.right;
    //     return helper(node.left, low, high)
    // }
}