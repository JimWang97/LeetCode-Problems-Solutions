package offer;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class offer68_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return null;
        }
        ans = root;
        helper(root, p, q);
        return ans;
    }

    public boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if(node==null) {
            return false;
        }
        boolean left = helper(node.left, p, q);
        boolean right = helper(node.right, p, q);
        boolean isSelf = node==p||node==q;
        if((left&&right) || (left &&isSelf) || (right&&isSelf)) {
            ans = node;
            return false;
        } else {
            return left||right||isSelf;
        }
    }
}
