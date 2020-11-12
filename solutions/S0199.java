package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4] 输出: [1, 3, 4] 解释:
 * 
 * 1 <--- / \ 2 3 <--- \ \ 5 4 <---
 * 
 * 时间复杂度 O(n)
 */
class S0199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        helper(queue);
        return ans;
    }

    public void helper(Queue<TreeNode> queue){
        TreeNode node=null;
        int length = queue.size();
        if(length==0) return;
        for(int i = 0 ;i<length;i++){
            TreeNode tn = queue.poll();
            if(tn!=null){
                node = tn;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        if(node!=null)
            ans.add(node.val);

        helper(queue);
    }
}