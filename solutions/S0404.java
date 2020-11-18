package solutions;

/**
 * 404. Sum of Left Leaves
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

时间复杂度O(n)
 */
public class S0404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        return helper(root.left, 0) + helper(root.right, 1);
    }

    public int helper(TreeNode root, int direction){
        if(root==null) return 0;
        if(root.left==null && root.right==null && direction==0) return root.val;
        int left=0,right=0;
        if(root.left!=null){
            left = helper(root.left, 0);
        }
        if(root.right!=null){
            right = helper(root.right, 1);
        }
        return left+right;
    }
}