package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 114. 二叉树展开为链表 给定一个二叉树，原地将它展开为一个单链表。
 * 
 * 
 * 
 * 例如，给定二叉树
 * 
 * 1 / \ 2 5 / \ \ 3 4 6 将其展开为：
 * 
 * 1 \ 2 \ 3 \ 4 \ 5 \ 6
 * 
 * 时间复杂度O(n)
 */
public class S0114 {
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

    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        travel(root);
        root = queue.poll();
        TreeNode node = root;
        while(queue.size()>0){
            node.left = null;
            node.right = queue.poll();
            node = node.right;
        }
    }

    public void travel(TreeNode node) {
        if(node == null) return;
        queue.add(node);
        travel(node.left);
        travel(node.right);
    }
}