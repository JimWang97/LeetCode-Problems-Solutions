package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 783. Minimum Distance Between BST Nodes Given a Binary Search Tree (BST) with
 * the root node root, return the minimum difference between the values of any
 * two different nodes in the tree.
 * 
 * Example :
 * 
 * Input: root = [4,2,6,1,3,null,null] Output: 1 Explanation: Note that root is
 * a TreeNode object, not an array.
 * 
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * 
 * 4 / \ 2 6 / \ 1 3
 * 
 * while the minimum difference in this tree is 1, it occurs between node 1 and
 * node 2, also between node 3 and node 2.
 * 
 * 时间复杂度 O(n)
 */
public class S0783 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> ls = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        travel(root);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < ls.size()-1; i ++){
            int n = ls.get(i+1) - ls.get(i);
            if(n<min) min=n;
        }
        return min;
    }

    public void travel(TreeNode node){
        if(node==null) return;
        travel(node.left);
        ls.add(node.val);
        travel(node.right);
    }
}