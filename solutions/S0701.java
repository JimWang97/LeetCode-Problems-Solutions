package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 701. Insert into a Binary Search Tree You are given the root node of a binary
 * search tree (BST) and a value to insert into the tree. Return the root node
 * of the BST after the insertion. It is guaranteed that the new value does not
 * exist in the original BST.
 * 
 * Notice that there may exist multiple valid ways for the insertion, as long as
 * the tree remains a BST after insertion. You can return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,2,7,1,3], val = 5 Output: [4,2,7,1,3,5] Explanation: Another
 * accepted tree is:
 * 
 * 时间复杂度 O(n)
 */
public class S0701 {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return new TreeNode(val);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                if(node.val>val){
                    if(node.left==null){
                        node.left = new TreeNode(val);
                        break;
                    }
                    queue.add(node.left);
                } else {
                    if(node.right==null){
                        node.right = new TreeNode(val);
                        break;
                    }
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}