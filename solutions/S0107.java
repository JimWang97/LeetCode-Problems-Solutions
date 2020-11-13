package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层次遍历 II 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如： 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 3 / \ 9 20 / \ 15 7 返回其自底向上的层次遍历为：
 * 
 * [ [15,7], [9,20], [3] ]
 * 
 * 时间复杂度 O(n)
 */
public class S0107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        helper(queue);
        return ans;
    }

    public void helper(Queue<TreeNode> queue){
        int len = queue.size();
        List<Integer> layer = new ArrayList<>();
        if(len==0) return;
        for(int i =0;i<len;i++){
            TreeNode node = queue.poll();
            if(node!=null){
                layer.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        if(layer.size()!=0)
            ans.add(0, layer);
        helper(queue);
    }
}