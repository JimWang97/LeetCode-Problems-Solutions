package solutions;

/**
 * 543. Diameter of Binary Tree
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    

      时间复杂度 O(n)
 */
public class S0543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max_dis = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root){
        if(root==null) return 0;
        helper(root);
        return max_dis;
    }

    public int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int dis = left + right;
        if(dis>max_dis) max_dis=dis;
        return Math.max(left,right) + 1;
    }
}