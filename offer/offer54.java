package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 */
public class offer54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> ls;
    public int kthLargest(TreeNode root, int k) {
        ls = new ArrayList<>();
        helper(root);
        return ls.get(ls.size()-k);
    }

    private void helper(TreeNode node) {
        if(node == null) {
            return;
        }
        helper(node.left);
        ls.add(node.val);
        helper(node.right);
    }

}
