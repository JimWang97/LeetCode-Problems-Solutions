package solutions;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0.

 

Example 1:



Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

时间复杂度 O(n)
 */
public class S1315 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, 1);
        return ans;
    }

    public void helper(TreeNode node, int isEven){
        if(node==null) return;
        if(isEven==0){
            if(node.left!=null) ans+=node.left.val;
            if(node.right!=null) ans+=node.right.val;
        }
        helper(node.left, node.val%2);
        helper(node.right, node.val%2);
    }
}