package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. Check Completeness of a Binary Tree Given a binary tree, determine if it
 * is a complete binary tree.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: [1,2,3,4,5,6] Output: true Explanation: Every level before the last is
 * full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last
 * level ({4, 5, 6}) are as far left as possible.
 * 
 * 时间复杂度 O(n)
 */
public class S0958 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return false;
        int flag = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null&&flag==1) return false;
            if(node.left!=null){
                queue.add(node.left);
            } else flag =1;
            if(node.right!=null && flag ==1) return false;
            if(node.right!=null){
                queue.add(node.right);
            } else flag =1;
        }
        return true;
    }
}