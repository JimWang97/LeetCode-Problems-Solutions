package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. All Possible Full Binary Trees A full binary tree is a binary tree where
 * each node has exactly 0 or 2 children.
 * 
 * Return a list of all possible full binary trees with N nodes. Each element of
 * the answer is the root node of one possible tree.
 * 
 * Each node of each tree in the answer must have node.val = 0.
 * 
 * You may return the final list of trees in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 7 Output:
 * [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 * 
 * 时间复杂度 O(n^2)
 */
public class S0894 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> ans = new ArrayList<>();
    
    public List<TreeNode> allPossibleFBT(int N) {
        TreeNode root = new TreeNode(0);
        if(N==0){
            ans.add(null);
            return ans;
        }
        if(N==1){
            ans.add(root);
            return ans;
        }

        N = N -1;
        for(int i = 1; i < N;i=i+2){
            int j = N-i;
            for(TreeNode left:helper(i)){
                for(TreeNode right:helper(j)){
                    root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public List<TreeNode> helper(int num){
        if(num==0) return null;
        List<TreeNode> tmp = new ArrayList<>();
        if(num ==1) {
            tmp.add(new TreeNode(0));
            return tmp;
        } 
        num = num -1;

        for(int i = 1;i<num;i=i+2){
            int j = num-i;
            for(TreeNode left:helper(i)){
                for(TreeNode right:helper(j)){
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    tmp.add(node);
                }
            }
        }
        return tmp;
    }
}