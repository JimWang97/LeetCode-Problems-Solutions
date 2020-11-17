package solutions;

/**
 * 979. Distribute Coins in Binary Tree
Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

 

Example 1:



Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

时间复杂度 O(n)
 */
public class S0979 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int ans=0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode node){
        if(node==null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        ans+=Math.abs(left) + Math.abs(right);
        return left+right+node.val-1;
    }
}