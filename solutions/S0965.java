package solutions;

/**
 * 965. Univalued Binary Tree
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

 

Example 1:


Input: [1,1,1,1,1,null,1]
Output: true

时间复杂度 O(n)
 */
public class S0965 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        return helper(root, root.val);
    }

    public boolean helper(TreeNode node, int val){
        if(node==null) return true;
        if(node.val==val){
            return helper(node.left, val) && helper(node.right, val);
        } else {
            return false;
        }
    }
}