package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. Deepest Leaves Sum Given a binary tree, return the sum of values of its
 * deepest leaves.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8] Output: 15
 * 
 * 时间复杂度 O(n)
 */
public class S1302 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return 0;
        int num=0;
        queue.add(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            num = 0;
            for(int i =0;i<sz;i++){
                TreeNode node = queue.poll();
                if(node!=null) {
                    num+=node.val;
                    if(node.left!=null) queue.add(node.left);
                    if(node.right!=null) queue.add(node.right);
                }
            }
            
        }
        return num;
    }
}