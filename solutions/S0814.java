package solutions;

/**
 * 814. 二叉树剪枝
给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。

返回移除了所有不包含 1 的子树的原二叉树。

( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

示例1:
输入: [1,null,0,0,1]
输出: [1,null,0,null,1]
 
解释: 
只有红色节点满足条件“所有不包含 1 的子树”。
右图为返回的答案。

时间复杂度 O(n)
 */
class S0814 {
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

    public TreeNode pruneTree(TreeNode root) {
        travel(root);
        if(root.val==0 && root.left==null && root.right==null) return null;
        return root;
    }

    public int travel(TreeNode root){
        if(root == null) return 0;
        int left_flag = travel(root.left);
        int right_flag = travel(root.right);

        if(left_flag==0){
            root.left = null;
        }
        if(right_flag==0){
            root.right = null;
        }

        return root.val | left_flag | right_flag;
    }
}