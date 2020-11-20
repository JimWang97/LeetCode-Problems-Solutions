package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST Given a binary search tree, write a
 * function kthSmallest to find the kth smallest element in it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1 3 / \ 1 4 \ 2 Output: 1
 * 
 * 时间复杂度 O(n)
 */
public class S0230 {
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

    List<Integer> ls = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        return ls.get(k-1);
    }

    public void helper(TreeNode node){
        if(node==null) return;
        helper(node.left);
        ls.add(node.val);
        helper(node.right);
    }
}