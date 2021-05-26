package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 */
public class S0515 {
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
        public List<Integer> largestValues(TreeNode root) {
            if(root==null) return new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            List<Integer> ans = new ArrayList<>();
            while(!q.isEmpty()) {
                int sz = q.size();
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < sz; i++) {
                    TreeNode node = q.poll();
                    if(node.val>max) max = node.val;
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                }
                ans.add(max);
            }
            return ans;
        }
    }
}
