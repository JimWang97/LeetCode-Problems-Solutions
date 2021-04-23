package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * <p>
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * 输出:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 */
public class S0623 {
    /**
     * Definition for a binary tree node.
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if(root==null) {
                return new TreeNode(val);
            }
            int idx = 1;
            TreeNode node = root;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty()) {
                int sz = q.size();
                for(int i = 0; i < sz; i ++) {
                    TreeNode n = q.poll();
                    TreeNode l = n.left;
                    TreeNode r = n.right;
                    if(idx+1==depth) {
                        n.left = new TreeNode(val, l, null);
                        n.right = new TreeNode(val, null, r);
                    } else {
                        if(l!=null) q.offer(l);
                        if(r!=null) q.offer(r);
                    }
                }
                idx++;
            }
            if(depth==0||depth==1||depth>idx) {
                TreeNode ans = new TreeNode(val, root, null);
                return ans;
            }
            return root;
        }
    }
}
