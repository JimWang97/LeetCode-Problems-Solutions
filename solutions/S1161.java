package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 */
public class S1161 {
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
        public int maxLevelSum(TreeNode root) {
            if(root==null) return 0;
            int ans = 1;
            int max = root.val;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int idx=0;
            while(!q.isEmpty()) {
                idx++;
                int sz = q.size();
                int tmpsum = 0;
                for(int i = 0; i < sz; i++) {
                    TreeNode node = q.poll();
                    tmpsum += node.val;
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                }
                if(tmpsum>max) {
                    max = tmpsum;
                    ans = idx;
                }
            }
            return ans;
        }
    }
}
