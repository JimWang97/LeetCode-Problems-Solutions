package solutions;
import java.util.List;
import java.util.ArrayList;
/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 
 * 时间复杂度O(n)
 */
class S0094 {
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

    public List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        travel(root);
        return ans;
    }     

    public void travel(TreeNode node){
        if(node == null) return;
        travel(node.left);
        ans.add(node.val);
        travel(node.right);
    }
}