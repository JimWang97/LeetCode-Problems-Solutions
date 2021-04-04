package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.08. 首个共同祖先
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * <p>
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 3
 * / \
 * 5   1
 * / \ / \
 * 6  2 0  8
 * / \
 * 7   4
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class interview_04_08 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<List<TreeNode>> ls;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ls = new ArrayList<>();
            dfs(root, p, q, new ArrayList<TreeNode>());
            List<TreeNode> ll1 = ls.get(0);
            List<TreeNode> ll2 = ls.get(1);
            int idx = 0;
            for(int i = 0; i < ll1.size() && i<ll2.size();i++) {
                if(ll1.get(i)!=ll2.get(i)) break;
                idx++;
            }
            return ll1.get(idx-1);
        }

        private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> ll) {
            if(root == null) return;
            ll.add(root);
            if(root==p||root==q) {
                ls.add(new ArrayList<>(ll));
            }
            dfs(root.left,p,q,ll);
            dfs(root.right,p,q,ll);
            ll.remove(root);
        }
    }
}
