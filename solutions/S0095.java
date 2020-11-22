package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II Given an integer n, generate all
 * structurally unique BST's (binary search trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * Input: 3 Output: [ [1,null,3,2], [3,2,null,1], [3,1,null,null,2], [2,1,3],
 * [1,null,2,null,3] ] Explanation: The above output corresponds to the 5 unique
 * BST's shown below:
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 */
public class S0095 {
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

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int lo, int hi){
        List<TreeNode> ls = new ArrayList<>();
        if(lo>hi) {
            ls.add(null);
            return ls;
        }
        
        for(int i = lo; i <= hi ; i++){
            
            List<TreeNode> left = buildTree(lo, i-1);
            List<TreeNode> right = buildTree(i+1, hi);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ls.add(root);
                }
            }
        }
        return ls;
    }
}