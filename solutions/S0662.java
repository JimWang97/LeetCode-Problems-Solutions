package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. Maximum Width of Binary Tree Given a binary tree, write a function to
 * get the maximum width of the given tree. The maximum width of a tree is the
 * maximum width among all levels.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 * 
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 1 / \ 3 2 / \ \ 5 3 9
 * 
 * Output: 4 Explanation: The maximum width existing in the third level with the
 * length 4 (5,3,null,9).
 * 
 * 时间复杂度O(n)
 */
public class S0662 {
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

    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth=0,left=0,ans=0;
        while(!queue.isEmpty()){
            AnnotatedNode a = queue.poll();
            if(a.node!=null){
                queue.add(new AnnotatedNode(a.node.left, a.depth+1, a.pos*2));
                queue.add(new AnnotatedNode(a.node.right, a.depth+1, a.pos*2+1));
                if(curDepth!=a.depth){
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left +1);
            }
        }
        return ans;
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p){
            node = n;
            depth = d;
             pos = p;
        }
    }
}