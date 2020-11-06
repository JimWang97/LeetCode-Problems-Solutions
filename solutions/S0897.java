package solutions;

/**
 * 
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * 
 * 时间复杂度 O(n) 空间复杂度O(n)
 */
class S0897{

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode n_root = new TreeNode(0);
    TreeNode n_node = n_root;
    public TreeNode increasingBST(TreeNode root) {
        travel(root);
        return n_root.right;
    }

    public void travel(TreeNode node){
        if(node == null) return;
        travel(node.left);
        n_node.right = new TreeNode(node.val);
        n_node = n_node.right;
        travel(node.right);
    }
}