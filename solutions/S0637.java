package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree Given a non-empty binary tree, return
 * the average value of the nodes on each level in the form of an array. Example
 * 1: Input: 3 / \ 9 20 / \ 15 7 Output: [3, 14.5, 11] Explanation: The average
 * value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * 
 * 时间复杂度 O(n)
 */
public class S0637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            double sum = 0;
            int num = 0;
            for(int i = 0; i < sz; i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    sum+=node.val;
                    num++;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(num!=0) ans.add((double)sum*1.0/num);
        }
        return ans;
    }
}