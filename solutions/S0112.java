package solutions;

/**
 * 
 * 112. 路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

时间复杂度 O(n)
 */
class S0112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return travel(root, sum);
    }

    public boolean travel(TreeNode root, int sum){
        if(root==null) return false;
        if(root.left==null && root.right == null){
            if(sum-root.val ==0){
                return true;
            } else {
                return false;
            }
        }
        return travel(root.left, sum-root.val) | travel(root.right,sum-root.val);
    }
}