package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 863. All Nodes Distance K in Binary Tree We are given a binary tree (with
 * root node root), a target node, and an integer value K.
 * 
 * Return a list of the values of all nodes that have a distance K from the
 * target node. The answer can be returned in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 
 * Output: [7,4,1]
 * 
 * Explanation: The nodes that are a distance 2 from the target node (with value
 * 5) have values 7, 4, and 1.
 * 
 */
public class S0863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> ans;
    TreeNode target;
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node){
        if(node==null) return -1;
        else if(node==target){
            subtree_add(node,0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if(L!=-1){
                if(L==K) ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if(R!=-1){
                if(R==K) ans.add(node.val);
                subtree_add(node.left, R+1);
                return R+1;
            } else {
                return -1;
            }
        }
    }

    public void subtree_add(TreeNode node, int dist){
        if(node == null) return ;
        if(dist==K){
            ans.add(node.val);
        } else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}