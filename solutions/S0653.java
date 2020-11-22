package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. Two Sum IV - Input is a BST Given the root of a Binary Search Tree and a
 * target number k, return true if there exist two elements in the BST such that
 * their sum is equal to the given target.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,7], k = 9 Output: true
 * 
 * 时间复杂度 O(n)
 */
public class S0653 {
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
    public boolean findTarget(TreeNode root, int k) {
        midorder(root);
        int sz = ls.size();
        int lo=0, hi=sz-1;
        while(lo<hi){
            if(ls.get(lo)+ls.get(hi)==k) return true;
            else if(ls.get(lo) +ls.get(hi)<k) lo++;
            else hi--;
        }
        return false;
    }

    public void midorder(TreeNode node){
        if(node == null) return;
        midorder(node.left);
        ls.add(node.val);
        midorder(node.right);
    }
}