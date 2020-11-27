package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. Binary Search Tree Iterator Implement an iterator over a binary search
 * tree (BST). Your iterator will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * 
 * BSTIterator iterator = new BSTIterator(root); iterator.next(); // return 3
 * iterator.next(); // return 7 iterator.hasNext(); // return true
 * iterator.next(); // return 9 iterator.hasNext(); // return true
 * iterator.next(); // return 15 iterator.hasNext(); // return true
 * iterator.next(); // return 20 iterator.hasNext(); // return false
 */
public class S0173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> ls = new ArrayList<>();
    int i = -1;
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        ++i;
        return ls.get(i);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return i<=ls.size()-1?true:false;
    }

    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        ls.add(node.val);
        dfs(node.right);
    }
}