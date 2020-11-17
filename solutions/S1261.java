package solutions;

/**
 * 1261. Find Elements in a Contaminated Binary Tree
Given a binary tree with the following rules:

root.val == 0
If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

You need to first recover the binary tree and then implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
bool find(int target) Return if the target value exists in the recovered binary tree.
 

Example 1:



Input
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
Output
[null,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1]); 
findElements.find(1); // return False 
findElements.find(2); // return True 

时间复杂度 O(n)
 */
public class S1261 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode root;
    public FindElements(TreeNode root) {
        helper(root, 0);
        this.root = root;
    }

    public void helper(TreeNode node, int value){
        if(node==null) return;
        if(node.left!=null){
            node.left.val = 2*value+1;
            helper(node.left, node.left.val);
        }
        if(node.right!=null){
            node.right.val=2*value+2;
            helper(node.right, node.right.val);
        }
    }
    
    public boolean find(int target) {
        return findHelper(target, this.root);
    }

    public boolean findHelper(int target, TreeNode node){
        if(node==null) return false;
        if(target<node.val) return false;
        if(target==node.val) return true;
        return findHelper(target, node.left) | findHelper(target, node.right);
    }
}