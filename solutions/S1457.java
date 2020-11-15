package solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

 

Example 1:



Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).

时间复杂度 O(n)
 */
class S1457 {
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

    int ans=0;
    HashMap<Integer, Boolean> map = new HashMap<>();
    int singels=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        
        travel(root);
        return ans;
    }

    public void travel(TreeNode node){
        Boolean flag = map.get(node.val);
        if (flag == null) flag = false;
        map.put(node.val, !flag);

        // 计算不成对数量
        if (flag) singels--;
        else singels++;

        // 到达路径尽头
        if (node.left == null && node.right == null) {
            if (singels <= 1) ans++;
        }

        if(node.left!=null) travel(node.left);
        if(node.right!=null) travel(node.right);
        map.put(node.val, flag);
        if (flag) singels++;
        else singels--;
    }
}